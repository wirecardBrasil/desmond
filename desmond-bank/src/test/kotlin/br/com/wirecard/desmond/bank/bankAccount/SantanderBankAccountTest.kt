package br.com.wirecard.desmond.bank.bankAccount

import org.junit.Test
import java.lang.Exception
import kotlin.test.fail

import br.com.wirecard.desmond.bank.bankAccount.BankAccountHelper as helper

class SantanderBankAccountTest {
    @Test
    fun allBankAccountsShouldBeValid() {
        val bankAccounts = helper.getSantanderBankAccountList()
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