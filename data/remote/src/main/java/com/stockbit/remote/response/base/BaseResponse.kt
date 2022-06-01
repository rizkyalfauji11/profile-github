package com.stockbit.remote.response.base

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("hasWarning")
    var hasWarning: Boolean? = null,

    @SerializedName("Data")
    var data: T? = null,

    @SerializedName("Message")
    var message: String? = null,
)