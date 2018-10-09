package br.com.wirecard.desmond.bank

sealed class Bank(val bankCode: String, val bankName: String) {
    object BancoDoBrasil : Bank("001", "BCO DO BRASIL S.A.")
    object Bradesco : Bank("237", "BCO BRADESCO S.A.")
    object Santander : Bank("033", "BCO SANTANDER (BRASIL) S.A.")
}