package br.com.wirecard.desmond.bank.bankAccount

import org.junit.Test
import java.lang.Exception
import kotlin.test.fail

class BBBankAccountTest {
    @Test
    fun allBankAccountsShouldBeValid() {
        val bankAccounts = BankAccountHelper.getBancoDoBrasilBankAccountList()
        for (bankAccount in bankAccounts) {
            try {
                bankAccount.isValid()
            } catch (e: Exception) {
                println(bankAccount)
                fail(e.message)
            }
        }
    }
}