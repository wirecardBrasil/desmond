package br.com.wirecard.desmond.bank.generator.bank

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.MismatchedBankException
import br.com.wirecard.desmond.bank.generator.BankAccountGenerator
import br.com.wirecard.desmond.extension.normalizeNumber
import br.com.wirecard.desmond.helper.BankGeneratorHelper as helper
import br.com.wirecard.desmond.helper.RemainderHelper as remainderHelper

/**
 * Bradesco Bank Account Generator
 *
 * Generates valid Bank Account objects for Bradesco
 * Refer to /docs/BRADESCO.md for the check digit algorithm
 */
class BradescoBankAccountGenerator {
    companion object : BankAccountGenerator {
        override fun generate(bankAccount: BankAccount): BankAccount {
            if (bankAccount.bank != Bank.Bradesco)
                throw MismatchedBankException(Bank.Bradesco, bankAccount.bank)
            val agencyCheckDigit = generateAgencyCheckDigit(bankAccount.agencyNumber)
            val accountCheckDigit = generateAccountCheckDigit(bankAccount.accountNumber)
            return bankAccount.copy(agencyCheckDigit = agencyCheckDigit, accountCheckDigit = accountCheckDigit)
        }

        private fun generateAgencyCheckDigit(agencyNumber: String): String {
            val weight = helper.BRADESCO_AGENCY_WEIGHT
            val normalizedNumber = agencyNumber.normalizeNumber(weight.size)
            return calculateCheckDigit(normalizedNumber, weight)
        }

        private fun generateAccountCheckDigit(accountNumber: String): String {
            val weight = helper.BRADESCO_ACCOUNT_WEIGHT
            val normalizedNumber = accountNumber.normalizeNumber(weight.size)
            return calculateCheckDigit(normalizedNumber, weight)
        }

        private fun calculateCheckDigit(number: String, weight: Array<Int>): String {
            val mod = helper.BRADESCO_MOD
            val remainder = remainderHelper.getRemainder(number, weight, mod)
            val subtraction = mod - remainder
            return when (subtraction) {
                11 -> "0"
                10 -> "P"
                else -> subtraction.toString()
            }
        }
    }
}