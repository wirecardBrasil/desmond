package br.com.wirecard.desmond.bank.validator

import br.com.wirecard.desmond.bank.BankAccount

abstract class BankValidator {
    abstract fun validateAgencyCheckDigit(agencyNumber: String, checkDigit: String): Boolean

    abstract fun validateAccountCheckDigit(accountNumber: String, checkDigit: String): Boolean

    fun validate(bankAccount: BankAccount): Boolean =
            validateAgencyCheckDigit(bankAccount.agencyNumber, bankAccount.agencyCheckDigit) &&
                    validateAccountCheckDigit(bankAccount.accountNumber, bankAccount.accountCheckNumber)
}