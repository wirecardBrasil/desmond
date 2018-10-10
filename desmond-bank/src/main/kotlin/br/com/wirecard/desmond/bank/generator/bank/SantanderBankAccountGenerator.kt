package br.com.wirecard.desmond.bank.generator.bank

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import br.com.wirecard.desmond.bank.exception.MismatchedBankException
import br.com.wirecard.desmond.bank.generator.BankAccountGenerator

import br.com.wirecard.desmond.helper.BankGeneratorHelper as helper
import br.com.wirecard.desmond.helper.RemainderHelper as remainderHelper
import br.com.wirecard.desmond.helper.RemainderCalculator.LastDigitOnly as calculator

/**
 * Santander Bank Account Generator
 *
 * Generates valid Bank Account objects for Santander
 * Refer to /docs/SANTANDER.md for the check digit algorithm
 */
class SantanderBankAccountGenerator {
    companion object : BankAccountGenerator {
        override fun generate(bankAccount: BankAccount): BankAccount {
            if (bankAccount.bank != Bank.Santander)
                throw MismatchedBankException(Bank.Santander, bankAccount.bank)
            val accountCheckDigit = generateAccountCheckDigit(bankAccount)
            return bankAccount.copy(accountCheckDigit = accountCheckDigit)
        }

        private fun generateAccountCheckDigit(bankAccount: BankAccount): String {
            var agencyNumber = bankAccount.agencyNumber
            var accountNumber = bankAccount.accountNumber

            if (agencyNumber.length > helper.SANTANDER_AGENCY_LENGTH)
                throw InvalidNumberLengthException(helper.SANTANDER_AGENCY_LENGTH, agencyNumber.length)
            if (accountNumber.length > helper.SANTANDER_ACCOUNT_LENGTH)
                throw InvalidNumberLengthException(helper.SANTANDER_ACCOUNT_LENGTH, accountNumber.length)

            agencyNumber = agencyNumber.padStart(helper.SANTANDER_AGENCY_LENGTH, '0')
            accountNumber = accountNumber.padStart(helper.SANTANDER_ACCOUNT_LENGTH, '0')

            val agencyAndAccountNumber = agencyNumber + accountNumber
            return calculateCheckDigit(agencyAndAccountNumber, helper.SANTANDER_WEIGHT)
        }

        private fun calculateCheckDigit(number: String, weight: Array<Int>): String {
            val mod = helper.SANTANDER_MOD
            val remainder = remainderHelper.getRemainder(number, weight, mod, calculator)
            val subtraction = helper.SANTANDER_MOD - remainder
            return when (subtraction) {
                10 -> "0"
                else -> subtraction.toString()
            }
        }
    }
}