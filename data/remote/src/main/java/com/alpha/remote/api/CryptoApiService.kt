package com.alpha.remote.api

import com.alpha.remote.response.base.BaseResponse
import com.alpha.remote.response.crypto.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApiService {
    @GET("data/top/totaltoptiervolfull")
    suspend fun fetchCryptoAsync(
        @Query("tsym") symbol: String = "IDR",
        @Query("page") page: Int = 1
    ): Response<BaseResponse<List<CryptoResponse>?>>
}