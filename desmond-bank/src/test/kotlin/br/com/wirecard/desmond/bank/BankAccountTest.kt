package br.com.wirecard.desmond.bank

import com.winterbe.expekt.should
import org.junit.Test

import br.com.wirecard.desmond.bank.BankObjectFactory as objectFactory

class BankAccountTest {
    @Test
    fun shouldBeValid() {
        val agencyNumber = objectFactory.VALID_AGENCY_NUMBER
        val accountNumber = objectFactory.VALID_ACCOUNT_NUMBER
        val checkDigit = objectFactory.VALID_CHECK_DIGIT
        val bankAccount = BankAccount(Bank.BANCO_DO_BRASIL, agencyNumber, checkDigit, accountNumber, checkDigit)
        bankAccount.isValid().should.be.`true`
    }
}