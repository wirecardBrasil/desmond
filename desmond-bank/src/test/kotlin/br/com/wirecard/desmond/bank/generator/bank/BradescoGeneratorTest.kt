package br.com.wirecard.desmond.bank.generator.bank

import com.winterbe.expekt.should
import org.junit.Test

import br.com.wirecard.desmond.bank.factory.BradescoObjectFactory as objectFactory
import br.com.wirecard.desmond.bank.generator.bank.BradescoGenerator as generator

class BradescoGeneratorTest {
    @Test
    fun shouldReturnCorrectAgencyCheckDigit() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        generator.generateAgencyCheckDigit(validAgencyNumber).should.equal(validCheckDigit)
    }

    @Test
    fun shouldReturnCorrectAgencyCheckDigitWhenSubtractionIsEleven() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER_SUBTRACTION_ELEVEN
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_SUBTRACTION_ELEVEN
        generator.generateAgencyCheckDigit(validAgencyNumber).should.equal(validCheckDigit)
    }

    @Test
    fun shouldReturnCorrectAgencyCheckDigitWhenSubtractionIsTen() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER_SUBTRACTION_TEN
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_SUBTRACTION_TEN
        generator.generateAgencyCheckDigit(validAgencyNumber).should.equal(validCheckDigit)
    }

    @Test
    fun shouldReturnCorrectAgencyCheckDigitWhenNumberLengthIsTwo() {
        val validAgencyNumber = objectFactory.VALID_NUMBER_TWO_DIGITS
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_NUMBER_TWO_DIGITS
        generator.generateAgencyCheckDigit(validAgencyNumber).should.equal(validCheckDigit)
    }

    @Test
    fun shouldReturnCorrectAccountCheckDigit() {
        val validAgencyNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        generator.generateAccountCheckDigit(validAgencyNumber).should.equal(validCheckDigit)
    }

    @Test
    fun shouldReturnCorrectAccountCheckDigitWhenSubtractionIsEleven() {
        val validAgencyNumber = objectFactory.VALID_ACCOUNT_NUMBER_SUBTRACTION_ELEVEN
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_SUBTRACTION_ELEVEN
        generator.generateAccountCheckDigit(validAgencyNumber).should.equal(validCheckDigit)
    }

    @Test
    fun shouldReturnCorrectAccountCheckDigitWhenSubtractionIsTen() {
        val validAgencyNumber = objectFactory.VALID_ACCOUNT_NUMBER_SUBTRACTION_TEN
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_SUBTRACTION_TEN
        generator.generateAccountCheckDigit(validAgencyNumber).should.equal(validCheckDigit)
    }

    @Test
    fun shouldReturnCorrectAccountCheckDigitWhenNumberLengthIsTwo() {
        val validAgencyNumber = objectFactory.VALID_NUMBER_TWO_DIGITS
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_NUMBER_TWO_DIGITS
        generator.generateAccountCheckDigit(validAgencyNumber).should.equal(validCheckDigit)
    }
}