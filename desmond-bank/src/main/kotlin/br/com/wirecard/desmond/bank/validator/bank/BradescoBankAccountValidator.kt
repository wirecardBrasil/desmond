package br.com.wirecard.desmond.bank.validator.bank

import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import br.com.wirecard.desmond.bank.validator.BankAccountValidator

import br.com.wirecard.desmond.bank.generator.bank.BradescoBankAccountGenerator as generator

/**
 * Bradesco Bank Account Validator
 *
 * Validates Bank Account objects for Bradesco
 * Refer to /docs/BRADESCO.md for the check digit algorithm
 */
class BradescoBankAccountValidator {
    companion object : BankAccountValidator {
        override fun validate(bankAccount: BankAccount): Boolean {
            if (bankAccount.agencyCheckDigit.isEmpty() || bankAccount.accountCheckDigit.isEmpty())
                throw EmptyCheckDigitException()
            val generatedBankAccount = generator.generate(bankAccount)
            if (generatedBankAccount.agencyCheckDigit != bankAccount.agencyCheckDigit)
                throw InvalidCheckDigitException(generatedBankAccount.agencyCheckDigit, bankAccount.agencyCheckDigit)
            if (generatedBankAccount.accountCheckDigit != bankAccount.accountCheckDigit)
                throw InvalidCheckDigitException(generatedBankAccount.accountCheckDigit, bankAccount.accountCheckDigit)
            return true
        }
    }
}