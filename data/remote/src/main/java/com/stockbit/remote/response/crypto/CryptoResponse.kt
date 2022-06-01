package com.stockbit.remote.response.crypto

import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoResponse? = null,
    @SerializedName("RAW")
    val display: DisplayResponse? = null,
)

data class CoinInfoResponse(
    @SerializedName("Id")
    val id: String? = null,

    @SerializedName("Name")
    val name: String? = null,

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
    val price: Double? = null
)
