package br.com.wirecard.desmond.bank

import br.com.wirecard.desmond.bank.validator.BancoDoBrasilValidator

class BankAccount(
    val bank: Bank,
    val agencyNumber: String,
    val agencyCheckDigit: String,
    val accountNumber: String,
    val accountCheckNumber: String
) {
    fun isValid(): Boolean {
        return when (bank) {
            Bank.BANCO_DO_BRASIL -> BancoDoBrasilValidator.validate(this)
        }
    }
}