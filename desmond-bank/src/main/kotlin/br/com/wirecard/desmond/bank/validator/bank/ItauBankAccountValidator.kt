package br.com.wirecard.desmond.bank.validator.bank

import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import br.com.wirecard.desmond.bank.validator.BankAccountValidator

import br.com.wirecard.desmond.bank.generator.bank.ItauBankAccountGenerator as generator

/**
 * Itaú Bank Account Validator
 *
 * Validates Bank Account objects for Itaú
 * Refer to /docs/ITAU.md for the check digit algorithm
 */
class ItauBankAccountValidator {
    companion object : BankAccountValidator {
        override fun validate(bankAccount: BankAccount): Boolean {
            if (bankAccount.accountCheckDigit.isEmpty())
                throw EmptyCheckDigitException()
            val generatedBankAccount = generator.generate(bankAccount)
            if (generatedBankAccount.accountCheckDigit != bankAccount.accountCheckDigit)
                throw InvalidCheckDigitException(generatedBankAccount.accountCheckDigit, bankAccount.accountCheckDigit)
            return true
        }
    }
}