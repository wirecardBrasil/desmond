package br.com.wirecard.desmond.extension

import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException

fun String.normalizeNumber(correctLength: Int): String {
    if (this.length > correctLength)
        throw InvalidNumberLengthException(correctLength, this.length)
    return this.padStart(correctLength, '0')
}