package br.com.wirecard.desmond.bank.generator.bank

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import br.com.wirecard.desmond.bank.exception.MismatchedBankException
import br.com.wirecard.desmond.bank.generator.BankAccountGenerator
import br.com.wirecard.desmond.extension.normalizeNumber

import br.com.wirecard.desmond.helper.BankGeneratorHelper as helper
import br.com.wirecard.desmond.helper.RemainderHelper as remainderHelper
import br.com.wirecard.desmond.helper.RemainderCalculator.SumDigits as calculator

/**
 * Itaú Bank Account Generator
 *
 * Generates valid Bank Account objects for Itaú
 * Refer to /docs/ITAU.md for the check digit algorithm
 */
class ItauBankAccountGenerator {
    companion object : BankAccountGenerator {
        override fun generate(bankAccount: BankAccount): BankAccount {
            if (bankAccount.bank != Bank.Itau)
                throw MismatchedBankException(Bank.Itau, bankAccount.bank)
            val accountCheckDigit = generateAccountCheckDigit(bankAccount)
            return bankAccount.copy(accountCheckDigit = accountCheckDigit)
        }

        private fun generateAccountCheckDigit(bankAccount: BankAccount): String {
            val agencyNumber = bankAccount.agencyNumber.normalizeNumber(helper.ITAU_AGENCY_LENGTH)
            val accountNumber = bankAccount.accountNumber.normalizeNumber(helper.ITAU_ACCOUNT_LENGTH)
            val agencyAndAccountNumber = agencyNumber + accountNumber
            return calculateCheckDigit(agencyAndAccountNumber, helper.ITAU_WEIGHT)
        }

        private fun calculateCheckDigit(number: String, weight: Array<Int>): String {
            val remainder = remainderHelper.getRemainder(number, weight, helper.ITAU_MOD, calculator)
            val mod = helper.ITAU_MOD
            val subtraction = mod - remainder
            return when (remainder) {
                0 -> "0"
                else -> subtraction.toString()
            }
        }
    }
}