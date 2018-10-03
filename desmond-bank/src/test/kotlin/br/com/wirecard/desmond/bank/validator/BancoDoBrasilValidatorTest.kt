package br.com.wirecard.desmond.bank.validator

import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import com.winterbe.expekt.should
import org.junit.Test
import kotlin.test.assertFailsWith

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

    @Test
    fun shouldThrowCorrectExceptionWhenAgencyNumberHasInvalidLength() {
        val invalidAgencyNumber = objectFactory.INVALID_LENGTH_AGENCY_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val validAgencyNumberLength = objectFactory.VALID_AGENCY_NUMBER.length
        val invalidAgencyNumberLength = invalidAgencyNumber.length
        val exceptionMessage = exceptionHelper.INVALID_NUMBER_LENGTH_MESSAGE.format(
                validAgencyNumberLength, invalidAgencyNumberLength
        )
        assertFailsWith(InvalidNumberLengthException::class, exceptionMessage) {
            validator.validateAgencyCheckDigit(invalidAgencyNumber, validCheckDigit)
        }
    }

    @Test
    fun shouldThrowCorrectExceptionWhenAgencyCheckDigitIsEmpty() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val invalidCheckDigit = objectFactory.INVALID_EMPTY_CHECK_DIGIT
        assertFailsWith(EmptyCheckDigitException::class, exceptionHelper.EMPTY_CHECK_DIGIT_MESSAGE) {
            validator.validateAgencyCheckDigit(validAgencyNumber, invalidCheckDigit)
        }
    }

    @Test
    fun shouldThrowCorrectExceptionWhenAgencyCheckDigitIsInvalid() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val invalidCheckDigit = objectFactory.INVALID_CHECK_DIGIT
        val expectedCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val exceptionMessage = exceptionHelper.INVALID_CHECK_DIGIT_MESSAGE.format(expectedCheckDigit, invalidCheckDigit)
        assertFailsWith(InvalidCheckDigitException::class, exceptionMessage) {
            validator.validateAgencyCheckDigit(validAgencyNumber, invalidCheckDigit)
        }
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

    @Test
    fun shouldThrowCorrectExceptionWhenAccountNumberHasInvalidLength() {
        val invalidAccountNumber = objectFactory.INVALID_LENGTH_ACCOUNT_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val validAccountNumberLength = objectFactory.VALID_ACCOUNT_NUMBER.length
        val invalidAccountNumberLength = invalidAccountNumber.length
        val exceptionMessage = exceptionHelper.INVALID_NUMBER_LENGTH_MESSAGE.format(
                validAccountNumberLength, invalidAccountNumberLength
        )
        assertFailsWith(InvalidNumberLengthException::class, exceptionMessage) {
            validator.validateAgencyCheckDigit(invalidAccountNumber, validCheckDigit)
        }
    }

    @Test
    fun shouldThrowCorrectExceptionWhenAccountCheckDigitIsEmpty() {
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val invalidCheckDigit = objectFactory.INVALID_EMPTY_CHECK_DIGIT
        assertFailsWith(EmptyCheckDigitException::class, exceptionHelper.EMPTY_CHECK_DIGIT_MESSAGE) {
            validator.validateAgencyCheckDigit(validAccountNumber, invalidCheckDigit)
        }
    }

    @Test
    fun shouldThrowCorrectExceptionWhenAccountCheckDigitIsInvalid() {
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val invalidCheckDigit = objectFactory.INVALID_CHECK_DIGIT
        val expectedCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val exceptionMessage = exceptionHelper.INVALID_CHECK_DIGIT_MESSAGE.format(expectedCheckDigit, invalidCheckDigit)
        assertFailsWith(InvalidCheckDigitException::class, exceptionMessage) {
            validator.validateAccountCheckDigit(validAccountNumber, invalidCheckDigit)
        }
    }
}