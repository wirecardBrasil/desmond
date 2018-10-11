package br.com.wirecard.desmond.bank.bankAccount

import br.com.wirecard.desmond.bank.Bank
import br.com.wirecard.desmond.bank.BankAccount
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.nio.file.Files
import java.nio.file.Paths

object BankAccountHelper {

    const val VALID_ITAU_CSV = "valid/itau.csv"
    const val VALID_BB_CSV = "valid/bb.csv"

    fun getItauBankAccountList(): List<BankAccount> {
        val csvParser = getParser(VALID_ITAU_CSV)
        return convertCSV(Bank.Itau, csvParser)
    }

    fun getBancoDoBrasilBankAccountList(): List<BankAccount> {
        val csvParser = getParser(VALID_BB_CSV)
        return convertCSV(Bank.BancoDoBrasil, csvParser)
    }

    private fun getParser(file: String): CSVParser {
        val uri = javaClass.getResource("/banks/" + file).toURI()
        val reader = Files.newBufferedReader(Paths.get(uri))
        return CSVParser(reader, CSVFormat.DEFAULT)
    }

    private fun convertCSV(bank: Bank, csvParser: CSVParser): List<BankAccount> {
        val bankAccounts = mutableListOf<BankAccount>()
        for (csvRecord in csvParser) {
            val agencyNumber = csvRecord.get(0)
            val agencyCheckNumber = csvRecord.get(1).toUpperCase()
            val accountNumber = csvRecord.get(2)
            val accountCheckDigit = csvRecord.get(3)
            bankAccounts.add(BankAccount(bank, agencyNumber, agencyCheckNumber, accountNumber, accountCheckDigit))
        }
        return bankAccounts
    }
}