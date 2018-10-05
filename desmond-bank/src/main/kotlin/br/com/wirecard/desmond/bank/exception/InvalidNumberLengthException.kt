package br.com.wirecard.desmond.bank.exception

import br.com.wirecard.desmond.helper.ExceptionHelper as exceptionHelper

class InvalidNumberLengthException(
        val expectedLength: Int,
        val receivedLength: Int
) : Exception() {
    override val message: String?
        get() = exceptionHelper.INVALID_NUMBER_LENGTH_MESSAGE.format(expectedLength, receivedLength)
}