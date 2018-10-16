package br.com.wirecard.desmond.bank

sealed class Bank(val bankCode: String, val bankName: String) {
    object BancoDoBrasil : Bank("001", "BCO DO BRASIL S.A.")
    object Bradesco : Bank("237", "BCO BRADESCO S.A.")
    object Santander : Bank("033", "BCO SANTANDER (BRASIL) S.A.")
    object Itau : Bank("341", "ITAÚ UNIBANCO BM S.A.")
    object CEF : Bank("104", "CAIXA ECONOMICA FEDERAL")
    object Banrisul : Bank("041", "BCO DO ESTADO DO RS S.A.")
}