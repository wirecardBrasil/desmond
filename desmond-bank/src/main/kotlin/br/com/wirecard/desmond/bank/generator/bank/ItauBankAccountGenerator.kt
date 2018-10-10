package br.com.wirecard.desmond.bank.generator.bank

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import br.com.wirecard.desmond.bank.exception.MismatchedBankException
import br.com.wirecard.desmond.bank.generator.BankAccountGenerator

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
            var agencyNumber = bankAccount.agencyNumber
            var accountNumber = bankAccount.accountNumber

            if (agencyNumber.length > helper.ITAU_AGENCY_LENGTH)
                throw InvalidNumberLengthException(helper.ITAU_AGENCY_LENGTH, agencyNumber.length)
            if (accountNumber.length > helper.ITAU_ACCOUNT_LENGTH)
                throw InvalidNumberLengthException(helper.ITAU_ACCOUNT_LENGTH, accountNumber.length)

            agencyNumber = agencyNumber.padStart(helper.ITAU_AGENCY_LENGTH, '0')
            accountNumber = accountNumber.padStart(helper.ITAU_ACCOUNT_LENGTH, '0')

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