package br.com.wirecard.desmond.bank.generator

interface BankGenerator {
    fun generateAgencyCheckDigit(agencyNumber: String): String
    fun generateAccountCheckDigit(accountNumber: String): String
}