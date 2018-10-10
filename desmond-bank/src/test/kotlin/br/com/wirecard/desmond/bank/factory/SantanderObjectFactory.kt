package br.com.wirecard.desmond.bank.factory

object SantanderObjectFactory {
    const val VALID_AGENCY_NUMBER = "1234"
    const val VALID_ACCOUNT_NUMBER = "00001234"
    const val VALID_CHECK_DIGIT = "2"

    const val VALID_AGENCY_NUMBER_REMAINDER_ZERO = "1234"
    const val VALID_ACCOUNT_NUMBER_REMAINDER_ZERO = "00001238"
    const val VALID_CHECK_DIGIT_REMAINDER_ZERO = "0"

    const val VALID_AGENCY_NUMBER_TWO_DIGITS = "12"
    const val VALID_ACCOUNT_NUMBER_TWO_DIGITS = "34"
    const val VALID_CHECK_DIGIT_NUMBER_TWO_DIGITS = "2"

    const val INVALID_LENGTH_AGENCY_NUMBER = "00000"
    const val INVALID_LENGTH_ACCOUNT_NUMBER = "000000000"
    const val INVALID_CHECK_DIGIT = "1"
    const val INVALID_EMPTY_CHECK_DIGIT = ""
}