package br.com.wirecard.desmond.bank.validator

import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import br.com.wirecard.desmond.bank.generator.BancoDoBrasilGenerator.Companion as generatorCompanion

class BancoDoBrasilValidator {
    companion object : BankValidator() {
        override fun validateAgencyCheckDigit(agencyNumber: String, checkDigit: String) =
                validateCheckDigit(agencyNumber, checkDigit, generatorCompanion::generateAgencyCheckDigit)

        override fun validateAccountCheckDigit(accountNumber: String, checkDigit: String) =
                validateCheckDigit(accountNumber, checkDigit, generatorCompanion::generateAccountCheckDigit)

        private fun validateCheckDigit(number: String, checkDigit: String, generator: (String) -> String): Boolean {
            if (checkDigit.isEmpty()) throw EmptyCheckDigitException()
            val calculatedCheckDigit = generator(number)
            if (calculatedCheckDigit == checkDigit) return true
            throw InvalidCheckDigitException(calculatedCheckDigit, checkDigit)
        }
    }
}