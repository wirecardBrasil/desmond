package br.com.wirecard.desmond.helper

object RemainderHelper {
    fun getRemainder(
        number: String,
        weight: Array<Int>,
        mod: Int,
        calculator: RemainderCalculator = RemainderCalculator.Default,
        multiplier: Int = 1
    ) = when (calculator) {
        RemainderCalculator.Default -> calculateRemainder(number, weight, mod, multiplier) { value -> value }
        RemainderCalculator.LastDigitOnly -> calculateRemainder(number, weight, mod, multiplier) { value -> value % 10 }
        RemainderCalculator.SumDigits -> calculateRemainder(number, weight, mod, multiplier) { value -> (value / 10) + (value % 10) }
    }

    private fun calculateRemainder(number: String, weight: Array<Int>, mod: Int, multiplier: Int = 1, operator: (value: Int) -> Int): Int {
        return number.map(Character::getNumericValue).mapIndexed { i, digit ->
            operator(digit * weight[i])
        }.sum() * multiplier % mod
    }
}