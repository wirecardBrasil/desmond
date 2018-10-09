package br.com.wirecard.desmond.helper

import com.winterbe.expekt.should
import org.junit.Test
import br.com.wirecard.desmond.helper.BankGeneratorHelper as bankGeneratorHelper
import br.com.wirecard.desmond.helper.HelperObjectFactory as objectFactory

class BankGeneratorHelperTest {
    @Test
    fun shouldReturnCorrectRemainder() {
        val fakeNumber = objectFactory.FAKE_NUMBER
        val fakeWeight = objectFactory.FAKE_WEIGHT
        val fakeMod = objectFactory.FAKE_MOD
        val result = objectFactory.EXPECTED_REMAINDER
        bankGeneratorHelper.getRemainder(fakeNumber, fakeWeight, fakeMod).should.equal(result)
    }
}