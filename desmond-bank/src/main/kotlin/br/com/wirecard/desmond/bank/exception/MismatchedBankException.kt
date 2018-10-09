package br.com.wirecard.desmond.bank.exception

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.helper.ExceptionHelper as exceptionHelper

class MismatchedBankException(
    val expectedBank: Bank,
    val receivedBank: Bank
) : Exception() {
    override val message: String?
        get() = exceptionHelper.MISMATCHED_BANK_MESSAGE.format(expectedBank.bankName, receivedBank.bankName)
}