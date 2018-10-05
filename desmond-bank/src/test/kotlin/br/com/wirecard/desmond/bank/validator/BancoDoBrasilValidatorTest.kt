package br.com.wirecard.desmond.bank.validator

import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import com.winterbe.expekt.should
import org.junit.Test

import br.com.wirecard.desmond.bank.BankObjectFactory as objectFactory
import br.com.wirecard.desmond.bank.validator.BancoDoBrasilValidator as validator
import br.com.wirecard.desmond.helper.ExceptionHelper as exceptionHelper

class BancoDoBrasilValidatorTest {
    @Test
    fun shouldHaveValidAgencyCheckDigit() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        validator.validateAgencyCheckDigit(validAgencyNumber, validCheckDigit).should.be.`true`
    }

    @Test
    fun shouldHaveValidAgencyCheckDigitWhenSubtractionIsEleven() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER_SUBTRACTION_ELEVEN
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_SUBTRACTION_ELEVEN
        validator.validateAgencyCheckDigit(validAgencyNumber, validCheckDigit).should.be.`true`
    }

    @Test
    fun shouldHaveValidAgencyCheckDigitWhenSubtractionIsTen() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER_SUBTRACTION_TEN
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_SUBTRACTION_TEN
        validator.validateAgencyCheckDigit(validAgencyNumber, validCheckDigit).should.be.`true`
    }

    @Test(expected = InvalidNumberLengthException::class)
    fun shouldThrowCorrectExceptionWhenAgencyNumberHasInvalidLength() {
        val invalidAgencyNumber = objectFactory.INVALID_LENGTH_AGENCY_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        validator.validateAgencyCheckDigit(invalidAgencyNumber, validCheckDigit)
    }

    @Test(expected = EmptyCheckDigitException::class)
    fun shouldThrowCorrectExceptionWhenAgencyCheckDigitIsEmpty() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val invalidCheckDigit = objectFactory.INVALID_EMPTY_CHECK_DIGIT
        validator.validateAgencyCheckDigit(validAgencyNumber, invalidCheckDigit)
    }

    @Test(expected = InvalidCheckDigitException::class)
    fun shouldThrowCorrectExceptionWhenAgencyCheckDigitIsInvalid() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val invalidCheckDigit = objectFactory.INVALID_CHECK_DIGIT
        validator.validateAgencyCheckDigit(validAgencyNumber, invalidCheckDigit)
    }

    @Test
    fun shouldHaveValidAccountCheckDigit() {
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        validator.validateAccountCheckDigit(validAccountNumber, validCheckDigit).should.be.`true`
    }

    @Test
    fun shouldHaveValidAccountCheckDigitWhenSubtractionIsEleven() {
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER_SUBTRACTION_ELEVEN
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_SUBTRACTION_ELEVEN
        validator.validateAccountCheckDigit(validAccountNumber, validCheckDigit).should.be.`true`
    }

    @Test
    fun shouldHaveValidAccountCheckDigitWhenSubtractionIsTen() {
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER_SUBTRACTION_TEN
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_SUBTRACTION_TEN
        validator.validateAccountCheckDigit(validAccountNumber, validCheckDigit).should.be.`true`
    }

    @Test(expected = InvalidNumberLengthException::class)
    fun shouldThrowCorrectExceptionWhenAccountNumberHasInvalidLength() {
        val invalidAccountNumber = objectFactory.INVALID_LENGTH_ACCOUNT_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        validator.validateAgencyCheckDigit(invalidAccountNumber, validCheckDigit)
    }

    @Test(expected = EmptyCheckDigitException::class)
    fun shouldThrowCorrectExceptionWhenAccountCheckDigitIsEmpty() {
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val invalidCheckDigit = objectFactory.INVALID_EMPTY_CHECK_DIGIT
        validator.validateAgencyCheckDigit(validAccountNumber, invalidCheckDigit)
    }

    @Test(expected = InvalidCheckDigitException::class)
    fun shouldThrowCorrectExceptionWhenAccountCheckDigitIsInvalid() {
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val invalidCheckDigit = objectFactory.INVALID_CHECK_DIGIT
        validator.validateAccountCheckDigit(validAccountNumber, invalidCheckDigit)
    }
}