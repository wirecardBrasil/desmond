package br.com.wirecard.desmond.bank.exception

import br.com.wirecard.desmond.helper.ExceptionHelper as exceptionHelper

class InvalidCheckDigitException(
    val expectedCheckDigit: String,
    val receivedCheckDigit: String
) : Exception() {
    override val message: String?
        get() = exceptionHelper.INVALID_CHECK_DIGIT_MESSAGE.format(expectedCheckDigit, receivedCheckDigit)
}