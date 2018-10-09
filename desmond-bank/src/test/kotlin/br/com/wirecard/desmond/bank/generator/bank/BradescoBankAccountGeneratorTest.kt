package br.com.wirecard.desmond.bank.generator.bank

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import br.com.wirecard.desmond.bank.exception.InvalidNumberLengthException
import br.com.wirecard.desmond.bank.exception.MismatchedBankException
import com.winterbe.expekt.should
import org.junit.Test

import br.com.wirecard.desmond.bank.factory.BradescoObjectFactory as objectFactory
import br.com.wirecard.desmond.bank.generator.bank.BradescoBankAccountGenerator as generator

class BradescoBankAccountGeneratorTest {
    @Test
    fun shouldGenerateCorrectCheckDigits() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.Bradesco, validAgencyNumber, validAccountNumber)
        val generatedBankAccount = generator.generate(bankAccount)
        generatedBankAccount.agencyCheckDigit.should.equal(validCheckDigit)
        generatedBankAccount.accountCheckDigit.should.equal(validCheckDigit)
    }

    @Test
    fun shouldGenerateCorrectCheckDigitWhenRemainderIsZero() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER_REMAINDER_ZERO
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER_REMAINDER_ZERO
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_REMAINDER_ZERO
        val bankAccount = BankAccount(Bank.Bradesco, validAgencyNumber, validAccountNumber)
        val generatedBankAccount = generator.generate(bankAccount)
        generatedBankAccount.agencyCheckDigit.should.equal(validCheckDigit)
        generatedBankAccount.accountCheckDigit.should.equal(validCheckDigit)
    }

    @Test
    fun shouldGenerateCorrectCheckDigitWhenRemainderIsOne() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER_REMAINDER_ONE
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER_REMAINDER_ONE
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_REMAINDER_ONE
        val bankAccount = BankAccount(Bank.Bradesco, validAgencyNumber, validAccountNumber)
        val generatedBankAccount = generator.generate(bankAccount)
        generatedBankAccount.agencyCheckDigit.should.equal(validCheckDigit)
        generatedBankAccount.accountCheckDigit.should.equal(validCheckDigit)
    }

    @Test
    fun shouldGenerateCorrectCheckDigitWhenNumberRequiresPadding() {
        val validAgencyNumber = objectFactory.VALID_NUMBER_TWO_DIGITS
        val validAccountNumber = objectFactory.VALID_NUMBER_TWO_DIGITS
        val validCheckDigit = objectFactory.VALID_CHECK_DIGIT_NUMBER_TWO_DIGITS
        val bankAccount = BankAccount(Bank.Bradesco, validAgencyNumber, validAccountNumber)
        val generatedBankAccount = generator.generate(bankAccount)
        generatedBankAccount.agencyCheckDigit.should.equal(validCheckDigit)
        generatedBankAccount.accountCheckDigit.should.equal(validCheckDigit)
    }

    @Test(expected = InvalidNumberLengthException::class)
    fun shouldThrowCorrectExceptionWhenAgencyLengthIsIncorrect() {
        val invalidAgencyNumber = objectFactory.INVALID_LENGTH_AGENCY_NUMBER
        val validAccountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val bankAccount = BankAccount(Bank.Bradesco, invalidAgencyNumber, validAccountNumber)
        generator.generate(bankAccount)
    }

    @Test(expected = InvalidNumberLengthException::class)
    fun shouldThrowCorrectExceptionWhenAccountLengthIsIncorrect() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val invalidAccountNumber = objectFactory.INVALID_LENGTH_ACCOUNT_NUMBER
        val bankAccount = BankAccount(Bank.Bradesco, validAgencyNumber, invalidAccountNumber)
        generator.generate(bankAccount)
    }

    @Test(expected = MismatchedBankException::class)
    fun shouldThrowCorrectExceptionWithMismatchedBank() {
        val validAgencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val invalidAccountNumber = objectFactory.INVALID_LENGTH_ACCOUNT_NUMBER
        val bankAccount = BankAccount(Bank.BancoDoBrasil, validAgencyNumber, invalidAccountNumber)
        generator.generate(bankAccount)
    }
}