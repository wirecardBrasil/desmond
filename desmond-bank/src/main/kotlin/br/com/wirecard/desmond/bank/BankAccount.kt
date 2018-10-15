package br.com.wirecard.desmond.bank

import br.com.wirecard.desmond.bank.validator.bank.*


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

    constructor(
        bank: Bank,
        agencyNumber: String,
        accountNumber: String,
        accountCheckDigit: String
    ) : this(bank, agencyNumber, "", accountNumber, accountCheckDigit)

    fun isValid() = when (bank) {
        Bank.BancoDoBrasil -> BBBankAccountValidator.validate(this)
        Bank.Bradesco -> BradescoBankAccountValidator.validate(this)
        Bank.Santander -> SantanderBankAccountValidator.validate(this)
        Bank.Itau -> ItauBankAccountValidator.validate(this)
        Bank.CEF -> CEFBankAccountValidator.validate(this)
    }
}