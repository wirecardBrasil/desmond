package br.com.wirecard.desmond.bank.exception

import br.com.wirecard.desmond.helper.ExceptionHelper as exceptionHelper

class EmptyCheckDigitException : Exception() {
    override val message: String?
        get() = exceptionHelper.EMPTY_CHECK_DIGIT_MESSAGE
}