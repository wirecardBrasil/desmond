package br.com.wirecard.desmond.bank.validator.bank

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import com.winterbe.expekt.should
import org.junit.Test

import br.com.wirecard.desmond.bank.factory.BradescoObjectFactory as objectFactory
import br.com.wirecard.desmond.bank.validator.bank.BradescoBankAccountValidator as validator

class BradescoBankAccountValidatorTest {
    @Test
    fun shouldBeTrueForValidAgencyAndAccount() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.Bradesco, validAgencyNumber, validCheckDigit, validAccountNumber, validCheckDigit)
        validator.validate(bankAccount).should.be.`true`
    }

    @Test(expected = InvalidCheckDigitException::class)
    fun shouldThrowCorrectExceptionForInvalidAgencyCheckDigit() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val invalidAgencyCheckDigit = objectFactory.INVALID_CHECK_DIGIT
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val validAccountCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.Bradesco, validAgencyNumber, invalidAgencyCheckDigit, validAccountNumber, validAccountCheckDigit)
        validator.validate(bankAccount)
    }

    @Test(expected = InvalidCheckDigitException::class)
    fun shouldThrowCorrectExceptionForInvalidAccountCheckDigit() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val validAgencyCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val invalidAccountCheckDigit = objectFactory.INVALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.Bradesco, validAgencyNumber, validAgencyCheckDigit, validAccountNumber, invalidAccountCheckDigit)
        validator.validate(bankAccount)
    }

    @Test(expected = EmptyCheckDigitException::class)
    fun shouldThrowCorrectExceptionWhenAgencyCheckDigitIsEmpty() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val invalidAgencyCheckDigit = objectFactory.INVALID_EMPTY_CHECK_DIGIT
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val validAccountCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.Bradesco, validAgencyNumber, invalidAgencyCheckDigit, validAccountNumber, validAccountCheckDigit)
        validator.validate(bankAccount)
    }
}