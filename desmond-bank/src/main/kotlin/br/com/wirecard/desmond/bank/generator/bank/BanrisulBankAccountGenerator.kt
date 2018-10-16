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
 * Banrisul Bank Account Generator
 *
 * Generates valid Bank Account objects for Banrisul
 * Refer to /docs/BANRISUL.md for the check digit algorithm
 */
class BanrisulBankAccountGenerator {
    companion object : BankAccountGenerator {
        override fun generate(bankAccount: BankAccount): BankAccount {
            if (bankAccount.bank != Bank.Banrisul)
                throw MismatchedBankException(Bank.Banrisul, bankAccount.bank)
            val accountCheckDigit = generateAccountCheckDigit(bankAccount)
            val agencyNormalized = bankAccount.agencyNumber.normalizeNumber(helper.BANRISUL_AGENCY_LENGTH)
            return bankAccount.copy(accountCheckDigit = accountCheckDigit, agencyNumber = agencyNormalized)
        }

        private fun generateAccountCheckDigit(bankAccount: BankAccount): String {
            val accountNumber = bankAccount.accountNumber.normalizeNumber(helper.BANRISUL_ACCOUNT_LENGTH)
            return calculateCheckDigit(accountNumber, helper.BANRISUL_WEIGHT)
        }

        private fun calculateCheckDigit(number: String, weight: Array<Int>): String {
            val mod = helper.BANRISUL_MOD
            val remainder = remainderHelper.getRemainder(number, weight, mod, calculator)
            return when (remainder) {
                1 -> "6"
                0 -> "0"
                else -> (mod - remainder).toString()
            }
        }
    }
}