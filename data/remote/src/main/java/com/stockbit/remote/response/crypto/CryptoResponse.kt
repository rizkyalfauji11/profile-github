package com.stockbit.remote.response.crypto

import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoResponse? = null,
    @SerializedName("DISPLAY")
    val display: DisplayResponse? = null,
)

data class CoinInfoResponse(
    @SerializedName("Id")
    val name: String? = null,

    @SerializedName("Name")
    val id: String? = null,

    @SerializedName("FullName")
    val fullName: String? = null
)

data class DisplayResponse(
    @SerializedName("IDR", alternate = ["USD"])
    val currency: CurrencyResponse? = null
)

data class CurrencyResponse(
    @SerializedName("CHANGE24HOUR")
    val lastDayChange: Double? = null,

    @SerializedName("CHANGEPCT24HOUR")
    val lastDayPercentChange: Double? = null,

    @SerializedName("PRICE")
    val symbol: String? = null
)
