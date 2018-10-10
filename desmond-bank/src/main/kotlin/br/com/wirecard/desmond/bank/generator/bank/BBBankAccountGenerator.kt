package br.com.wirecard.desmond.bank.generator.bank

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import br.com.wirecard.desmond.bank.exception.MismatchedBankException
import br.com.wirecard.desmond.bank.generator.BankAccountGenerator

import br.com.wirecard.desmond.helper.BankGeneratorHelper as helper
import br.com.wirecard.desmond.helper.RemainderHelper as remainderHelper

/**
 * Banco do Brasil Bank Account Generator
 *
 * Generates valid Bank Account objects for Banco do Brasil
 * Refer to /docs/BANCO_DO_BRASIL.md for the check digit algorithm
 */
class BBBankAccountGenerator {
    companion object : BankAccountGenerator {
        override fun generate(bankAccount: BankAccount): BankAccount {
            if (bankAccount.bank != Bank.BancoDoBrasil)
                throw MismatchedBankException(Bank.BancoDoBrasil, bankAccount.bank)
            val agencyCheckDigit = generateAgencyCheckDigit(bankAccount.agencyNumber)
            val accountCheckDigit = generateAccountCheckDigit(bankAccount.accountNumber)
            return bankAccount.copy(agencyCheckDigit = agencyCheckDigit, accountCheckDigit = accountCheckDigit)
        }

        private fun generateAgencyCheckDigit(agencyNumber: String): String {
            val weight = helper.BANCO_DO_BRASIL_AGENCY_WEIGHT
            if (agencyNumber.length > weight.size)
                throw InvalidNumberLengthException(weight.size, agencyNumber.length)
            return calculateCheckDigit(agencyNumber, weight)
        }

        private fun generateAccountCheckDigit(accountNumber: String): String {
            val weight = helper.BANCO_DO_BRASIL_ACCOUNT_WEIGHT
            if (accountNumber.length > weight.size)
                throw InvalidNumberLengthException(weight.size, accountNumber.length)
            return calculateCheckDigit(accountNumber, weight)
        }

        private fun calculateCheckDigit(number: String, weight: Array<Int>): String {
            val paddedNumber = number.padStart(weight.size, '0')
            val mod = helper.BANCO_DO_BRASIL_MOD
            val remainder = remainderHelper.getRemainder(paddedNumber, weight, mod)
            val subtraction = mod - remainder
            return when (subtraction) {
                11 -> "0"
                10 -> "X"
                else -> subtraction.toString()
            }
        }
    }
}