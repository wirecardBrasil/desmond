package br.com.wirecard.desmond.bank

import br.com.wirecard.desmond.bank.validator.bank.BBBankAccountValidator
import br.com.wirecard.desmond.bank.validator.bank.BradescoBankAccountValidator

data class BankAccount(
    val bank: Bank,
    var agencyNumber: String,
    var agencyCheckDigit: String,
    var accountNumber: String,
    var accountCheckDigit: String
) {
    constructor(
        bank: Bank,
        agencyNumber: String,
        accountNumber: String
    ) : this(bank, agencyNumber, "", accountNumber, "")

    fun isValid(): Boolean {
        return when (bank) {
            Bank.BancoDoBrasil -> BBBankAccountValidator.validate(this)
            Bank.Bradesco -> BradescoBankAccountValidator.validate(this)
            Bank.Santander -> true
        }
    }
}