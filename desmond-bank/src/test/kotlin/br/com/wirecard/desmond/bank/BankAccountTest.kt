package br.com.wirecard.desmond.bank

import br.com.wirecard.desmond.bank.exception.EmptyCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidCheckDigitException
import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import com.winterbe.expekt.should
import org.junit.Test

import br.com.wirecard.desmond.bank.factory.BancoDoBrasilObjectFactory as bancoDoBrasilObjectFactory

class BankAccountTest {
    @Test
    fun shouldBeValidForBancoDoBrasil() {
        val agencyNumber = bancoDoBrasilObjectFactory.VALID_AGENCY_NUMBER
        val accountNumber = bancoDoBrasilObjectFactory.VALID_ACCOUNT_NUMBER
        val checkDigit = bancoDoBrasilObjectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, checkDigit, accountNumber, checkDigit)
        bankAccount.isValid().should.be.`true`
    }

    @Test(expected = InvalidNumberLengthException::class)
    fun shouldHaveInvalidAgencyLengthForBancoDoBrasil() {
        val agencyNumber = bancoDoBrasilObjectFactory.INVALID_LENGTH_AGENCY_NUMBER
        val accountNumber = bancoDoBrasilObjectFactory.VALID_ACCOUNT_NUMBER
        val checkDigit = bancoDoBrasilObjectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, checkDigit, accountNumber, checkDigit)
        bankAccount.isValid()
    }

    @Test(expected = InvalidNumberLengthException::class)
    fun shouldHaveInvalidAccountLengthForBancoDoBrasil() {
        val agencyNumber = bancoDoBrasilObjectFactory.VALID_AGENCY_NUMBER
        val accountNumber = bancoDoBrasilObjectFactory.INVALID_LENGTH_ACCOUNT_NUMBER
        val checkDigit = bancoDoBrasilObjectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, checkDigit, accountNumber, checkDigit)
        bankAccount.isValid()
    }

    @Test(expected = InvalidCheckDigitException::class)
    fun shouldHaveInvalidAgencyCheckNumberForBancoDoBrasil() {
        val agencyNumber = bancoDoBrasilObjectFactory.VALID_AGENCY_NUMBER
        val accountNumber = bancoDoBrasilObjectFactory.VALID_ACCOUNT_NUMBER
        val agencyCheckDigit = bancoDoBrasilObjectFactory.INVALID_CHECK_DIGIT
        val accountCheckDigit = bancoDoBrasilObjectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, agencyCheckDigit, accountNumber, accountCheckDigit)
        bankAccount.isValid()
    }

    @Test(expected = InvalidCheckDigitException::class)
    fun shouldHaveInvalidAccountCheckNumberForBancoDoBrasil() {
        val agencyNumber = bancoDoBrasilObjectFactory.VALID_AGENCY_NUMBER
        val accountNumber = bancoDoBrasilObjectFactory.VALID_ACCOUNT_NUMBER
        val agencyCheckDigit = bancoDoBrasilObjectFactory.VALID_CHECK_DIGIT
        val accountCheckDigit = bancoDoBrasilObjectFactory.INVALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, agencyCheckDigit, accountNumber, accountCheckDigit)
        bankAccount.isValid()
    }

    @Test(expected = EmptyCheckDigitException::class)
    fun shouldHaveEmptyCheckDigitForBancoDoBrasil() {
        val agencyNumber = bancoDoBrasilObjectFactory.VALID_AGENCY_NUMBER
        val accountNumber = bancoDoBrasilObjectFactory.VALID_ACCOUNT_NUMBER
        val checkDigit = bancoDoBrasilObjectFactory.INVALID_EMPTY_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, checkDigit, accountNumber, checkDigit)
        bankAccount.isValid()
    }
}