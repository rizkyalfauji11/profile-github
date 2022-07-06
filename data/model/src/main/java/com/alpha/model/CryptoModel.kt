package com.alpha.model

data class CryptoModel(
    val id: String? = null,
    val name: String? = null,
    val fullName: String? = null,
    val lastDayChange: Double? = null,
    val lastDayPercentChange: Double? = null,
    val price: Double? = null
)