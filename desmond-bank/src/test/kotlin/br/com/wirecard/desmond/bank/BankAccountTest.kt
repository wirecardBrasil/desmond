package br.com.wirecard.desmond.bank

import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import com.winterbe.expekt.should
import org.junit.Test

import br.com.wirecard.desmond.bank.BankObjectFactory as objectFactory
import br.com.wirecard.desmond.helper.ExceptionHelper as exceptionHelper

class BankAccountTest {
    @Test
    fun shouldBeValidForBancoDoBrasil() {
        val agencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val accountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val checkDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, checkDigit, accountNumber, checkDigit)
        bankAccount.isValid().should.be.`true`
    }

    @Test(expected = InvalidNumberLengthException::class)
    fun shouldHaveInvalidAgencyLengthForBancoDoBrasil() {
        val agencyNumber = objectFactory.INVALID_LENGTH_AGENCY_NUMBER
        val accountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val checkDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, checkDigit, accountNumber, checkDigit)
        bankAccount.isValid()
    }

    @Test(expected = InvalidNumberLengthException::class)
    fun shouldHaveInvalidAccountLengthForBancoDoBrasil() {
        val agencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val accountNumber = objectFactory.INVALID_LENGTH_ACCOUNT_NUMBER
        val checkDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, checkDigit, accountNumber, checkDigit)
        bankAccount.isValid()
    }

    @Test(expected = InvalidCheckDigitException::class)
    fun shouldHaveInvalidAgencyCheckNumberForBancoDoBrasil() {
        val agencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val accountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val agencyCheckDigit = objectFactory.INVALID_CHECK_DIGIT
        val accountCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, agencyCheckDigit, accountNumber, accountCheckDigit)
        bankAccount.isValid()
    }

    @Test(expected = InvalidCheckDigitException::class)
    fun shouldHaveInvalidAccountCheckNumberForBancoDoBrasil() {
        val agencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val accountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val agencyCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val accountCheckDigit = objectFactory.INVALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, agencyCheckDigit, accountNumber, accountCheckDigit)
        bankAccount.isValid()
    }

    @Test(expected = EmptyCheckDigitException::class)
    fun shouldHaveEmptyCheckDigitForBancoDoBrasil() {
        val agencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val accountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val checkDigit = objectFactory.INVALID_EMPTY_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, checkDigit, accountNumber, checkDigit)
        bankAccount.isValid()
    }
}