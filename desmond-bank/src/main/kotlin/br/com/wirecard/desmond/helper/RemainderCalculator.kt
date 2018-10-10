package br.com.wirecard.desmond.helper

sealed class RemainderCalculator {
    object Default : RemainderCalculator()
    object LastDigitOnly : RemainderCalculator()
}