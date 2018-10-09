package br.com.wirecard.desmond.helper

object ExceptionHelper {
    const val EMPTY_CHECK_DIGIT_MESSAGE = "Invalid check digit: received empty check digit"
    const val INVALID_CHECK_DIGIT_MESSAGE = "Invalid check digit: expected %s but received %s!"
    const val INVALID_NUMBER_LENGTH_MESSAGE = "Invalid number length: expected %s but received %s!"
    const val MISMATCHED_BANK_MESSAGE = "Unexpected bank: expected: %s but received %s!"
}