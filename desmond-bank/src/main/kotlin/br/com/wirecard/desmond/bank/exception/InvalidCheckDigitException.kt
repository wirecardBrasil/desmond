package br.com.wirecard.desmond.bank.exception

class InvalidCheckDigitException(
        val expectedCheckDigit: String,
        val receivedCheckDigit: String
) : Exception() {
    override val message: String?
        get() = "Invalid check digit: expected ${expectedCheckDigit} but received ${receivedCheckDigit}"
}