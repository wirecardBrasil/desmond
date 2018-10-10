package br.com.wirecard.desmond.helper

import com.winterbe.expekt.should
import org.junit.Test
import br.com.wirecard.desmond.helper.HelperObjectFactory as helper
import br.com.wirecard.desmond.helper.RemainderHelper as remainderHelper
import br.com.wirecard.desmond.helper.RemainderCalculator.LastDigitOnly as lastDigitOnlyCalculator

class RemainderHelperTest {
    @Test
    fun `Should return correct remainder when using default calculator`() {
        val fakeNumber = helper.FAKE_NUMBER_DEFAULT_CALCULATOR
        val fakeWeight = helper.FAKE_WEIGHT_DEFAULT_CALCULATOR
        val fakeMod = helper.FAKE_MOD_DEFAULT_CALCULATOR
        val expectedRemainder = helper.DEFAULT_CALCULATOR_EXPECTED_RESULT
        remainderHelper.getRemainder(fakeNumber, fakeWeight, fakeMod).should.equal(expectedRemainder)
    }

    @Test
    fun `Should return correct remainder when using last digit only calculator`() {
        val fakeNumber = helper.FAKE_NUMBER_LAST_DIGIT_ONLY_CALCULATOR
        val fakeWeight = helper.FAKE_WEIGHT_LAST_DIGIT_ONLY_CALCULATOR
        val fakeMod = helper.FAKE_MOD_LAST_DIGIT_ONLY_CALCULATOR
        val expectedRemainder = helper.LAST_DIGIT_ONLY_EXPECTED_RESULT
        remainderHelper.getRemainder(fakeNumber, fakeWeight, fakeMod, lastDigitOnlyCalculator).should.equal(expectedRemainder)
    }
}