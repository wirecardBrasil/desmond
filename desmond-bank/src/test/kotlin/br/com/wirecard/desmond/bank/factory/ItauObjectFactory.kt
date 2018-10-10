package br.com.wirecard.desmond.bank.factory

object ItauObjectFactory {
    const val VALID_AGENCY_NUMBER = "1234"
    const val VALID_ACCOUNT_NUMBER = "12345"
    const val VALID_CHECK_DIGIT = "1"

    const val VALID_AGENCY_NUMBER_REMAINDER_ZERO = "1111"
    const val VALID_ACCOUNT_NUMBER_REMAINDER_ZERO = "11010"
    const val VALID_CHECK_DIGIT_REMAINDER_ZERO = "0"

    const val VALID_AGENCY_NUMBER_TWO_DIGITS = "12"
    const val VALID_ACCOUNT_NUMBER_TWO_DIGITS = "34"
    const val VALID_CHECK_DIGIT_NUMBER_TWO_DIGITS = "5"
    const val INVALID_LENGTH_AGENCY_NUMBER = "00000"
    const val INVALID_LENGTH_ACCOUNT_NUMBER = "00000000"
}