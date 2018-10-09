package br.com.wirecard.desmond.bank.validator

import br.com.wirecard.desmond.bank.BankAccount

interface BankAccountValidator {
    fun validate(bankAccount: BankAccount): Boolean
}