package br.com.wirecard.desmond.bank.generator

import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import br.com.wirecard.desmond.helper.BankGeneratorHelper as bankGeneratorHelper

class BradescoGenerator {
    companion object : BankGenerator {
        override fun generateAgencyCheckDigit(agencyNumber: String): String {
            val weight = bankGeneratorHelper.BRADESCO_AGENCY_WEIGHT
            if (agencyNumber.length > weight.size)
                throw InvalidNumberLengthException(weight.size, agencyNumber.length)
            return calculateCheckDigit(agencyNumber, weight)
        }

        override fun generateAccountCheckDigit(accountNumber: String): String {
            val weight = bankGeneratorHelper.BRADESCO_ACCOUNT_WEIGHT
            if (accountNumber.length > weight.size)
                throw InvalidNumberLengthException(weight.size, accountNumber.length)
            return calculateCheckDigit(accountNumber, weight)
        }

        private fun calculateCheckDigit(number: String, weight: Array<Int>): String {
            val paddedNumber = number.padStart(weight.size, '0')
            val sum = bankGeneratorHelper.multiplyByWeight(paddedNumber, weight)
            val mod = sum % bankGeneratorHelper.BRADESCO_MOD
            val subtraction = bankGeneratorHelper.BRADESCO_MOD - mod
            return when (subtraction) {
                11 -> "0"
                10 -> "P"
                else -> subtraction.toString()
            }
        }
    }
}