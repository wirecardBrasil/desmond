package br.com.wirecard.desmond.bank.exception

class EmptyCheckDigitException : Exception() {
    override val message: String?
        get() = "Invalid check digit: received empty check digit"
}