package br.com.wirecard.desmond.bank.validator.bank

import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import br.com.wirecard.desmond.bank.validator.BankAccountValidator

import br.com.wirecard.desmond.bank.generator.bank.CEFBankAccountGenerator as generator

/**
 * Caixa Econômica Federal Bank Account Validator
 *
 * Validates Bank Account objects for Caixa Econômica Federal
 * Refer to /docs/CAIXA_ECONOMICA_FEDERAL.md for the check digit algorithm
 */
class CEFBankAccountValidator {
    companion object : BankAccountValidator {
        override fun validate(bankAccount: BankAccount): Boolean {
            if (bankAccount.accountCheckDigit.isEmpty())
                throw EmptyCheckDigitException()
            val generatedBankAccount = generator.generate(bankAccount)
            if (generatedBankAccount.accountCheckDigit != bankAccount.accountCheckDigit)
                throw InvalidCheckDigitException(generatedBankAccount.agencyCheckDigit, bankAccount.agencyCheckDigit)
            return true
        }
    }
}