package br.com.wirecard.desmond.bank.validator.bank

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import com.winterbe.expekt.should
import org.junit.Test

import br.com.wirecard.desmond.bank.factory.SantanderObjectFactory as objectFactory
import br.com.wirecard.desmond.bank.validator.bank.SantanderBankAccountValidator as validator

class SantanderBankAccountValidatorTest {
    @Test
    fun shouldBeTrueForValidAgencyAndAccount() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.Santander, validAgencyNumber, validCheckDigit, validAccountNumber, validCheckDigit)
        validator.validate(bankAccount).should.be.`true`
    }

    @Test(expected = InvalidCheckDigitException::class)
    fun shouldThrowCorrectExceptionForInvalidAccountCheckDigit() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val invalidAccountCheckDigit = objectFactory.INVALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.Santander, validAgencyNumber, validAccountNumber, invalidAccountCheckDigit)
        validator.validate(bankAccount)
    }

    @Test(expected = EmptyCheckDigitException::class)
    fun shouldThrowCorrectExceptionWhenAgencyCheckDigitIsEmpty() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val invalidAccountCheckDigit = objectFactory.INVALID_EMPTY_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BancoDoBrasil, validAgencyNumber, validAccountNumber, invalidAccountCheckDigit)
        validator.validate(bankAccount)
    }
}