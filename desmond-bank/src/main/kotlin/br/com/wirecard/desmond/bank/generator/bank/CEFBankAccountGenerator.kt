package br.com.wirecard.desmond.bank.generator.bank

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.MismatchedBankException
import br.com.wirecard.desmond.bank.generator.BankAccountGenerator
import br.com.wirecard.desmond.extension.normalizeNumber

import br.com.wirecard.desmond.helper.BankGeneratorHelper as helper
import br.com.wirecard.desmond.helper.RemainderHelper as remainderHelper
import br.com.wirecard.desmond.helper.RemainderCalculator.Default as calculator

/**
 * Caixa Econômica Federal Bank Account Generator
 *
 * Generates valid Bank Account objects for Caixa Econômica Federal
 * Refer to /docs/CAIXA_ECONOMICA_FEDERAL.md for the check digit algorithm
 */
class CEFBankAccountGenerator {
    companion object : BankAccountGenerator {
        override fun generate(bankAccount: BankAccount): BankAccount {
            if (bankAccount.bank != Bank.CEF)
                throw MismatchedBankException(Bank.CEF, bankAccount.bank)
            val accountCheckDigit = generateAccountCheckDigit(bankAccount)
            return bankAccount.copy(accountCheckDigit = accountCheckDigit)
        }

        private fun generateAccountCheckDigit(bankAccount: BankAccount): String {
            val agencyNumber = bankAccount.agencyNumber.normalizeNumber(helper.CEF_AGENCY_LENGTH)
            val accountNumber = bankAccount.accountNumber.normalizeNumber(helper.CEF_ACCOUNT_LENGTH)
            val agencyAndAccountNumber = agencyNumber + accountNumber
            return calculateCheckDigit(agencyAndAccountNumber, helper.CEF_WEIGHT)
        }

        private fun calculateCheckDigit(number: String, weight: Array<Int>): String {
            val mod = helper.CEF_MOD
            val remainder = remainderHelper.getRemainder(number, weight, mod, calculator, helper.CEF_MULTIPLIER)
            return when (remainder) {
                10 -> "0"
                else -> remainder.toString()
            }
        }
    }
}