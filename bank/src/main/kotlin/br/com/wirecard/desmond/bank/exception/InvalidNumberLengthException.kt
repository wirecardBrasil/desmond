package br.com.wirecard.desmond.bank.exception

class InvalidNumberLengthException(
        val expectedLength: Int,
        val receivedLength: Int
) : Exception() {
    override val message: String?
        get() = "Invalid number length: expected ${expectedLength} but received ${receivedLength}!"
}