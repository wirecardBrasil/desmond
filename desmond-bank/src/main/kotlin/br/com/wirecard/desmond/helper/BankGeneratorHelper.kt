package br.com.wirecard.desmond.helper

object BankGeneratorHelper {
    val BANCO_DO_BRASIL_AGENCY_WEIGHT = arrayOf(5, 4, 3, 2)
    val BRADESCO_AGENCY_WEIGHT = arrayOf(5, 4, 3, 2)
    val BANCO_DO_BRASIL_ACCOUNT_WEIGHT = arrayOf(9, 8, 7, 6, 5, 4, 3, 2)
    val BRADESCO_ACCOUNT_WEIGHT = arrayOf(2, 7, 6, 5, 4, 3, 2)
    val SANTANDER_WEIGHT = arrayOf(9, 7, 3, 1, 9, 7, 1, 3, 1, 9, 7, 3)
    const val BANCO_DO_BRASIL_MOD = 11
    const val BRADESCO_MOD = 11
    const val SANTANDER_MOD = 10
    const val SANTANDER_AGENCY_LENGTH = 4
    const val SANTANDER_ACCOUNT_LENGTH = 8

    fun getRemainder(number: String, weight: Array<Int>, mod: Int, lastDigitOnly: Boolean = false): Int {
        return number.map(Character::getNumericValue).mapIndexed { i, digit ->
            var remainder = digit * weight[i]
            if (lastDigitOnly)
                remainder %= 10
            remainder
        }.sum() % mod
    }
}