package br.com.wirecard.desmond.helper

object BankGeneratorHelper {
    val BANCO_DO_BRASIL_AGENCY_WEIGHT = arrayOf(5, 4, 3, 2)
    val BRADESCO_AGENCY_WEIGHT = arrayOf(5, 4, 3, 2)
    val BANCO_DO_BRASIL_ACCOUNT_WEIGHT = arrayOf(9, 8, 7, 6, 5, 4, 3, 2)
    val BRADESCO_ACCOUNT_WEIGHT = arrayOf(2, 7, 6, 5, 4, 3, 2)
    const val BANCO_DO_BRASIL_MOD = 11
    const val BRADESCO_MOD = 11

    fun multiplyByWeight(number: String, weight: Array<Int>): Int {
        return number.map(Character::getNumericValue).mapIndexed { i, digit -> digit * weight[i] }.sum()
    }
}