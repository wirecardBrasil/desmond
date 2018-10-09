package br.com.wirecard.desmond.bank.generator

import br.com.wirecard.desmond.bank.BankAccount

interface BankAccountGenerator {
    fun generate(bankAccount: BankAccount): BankAccount
}