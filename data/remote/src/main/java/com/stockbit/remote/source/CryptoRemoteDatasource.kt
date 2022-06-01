package com.stockbit.remote.source

import com.stockbit.remote.api.CryptoApiService
import com.stockbit.remote.response.crypto.CryptoResponse
import com.stockbit.remote.utils.ApiResponse

/**
 * Implementation of [CryptoApiService] interface
 */
class CryptoRemoteDatasource(private val apiService: CryptoApiService) {
    suspend fun fetchTopUsersAsync(page: Int, symbol: String): ApiResponse<List<CryptoResponse>?> {
        val response = apiService.fetchCryptoAsync(page = page, symbol = symbol)
        return if (response.isSuccessful) {
            val cryptoList = response.body()?.data
            if (cryptoList.isNullOrEmpty())
                ApiResponse.Empty
            else
                ApiResponse.Success(cryptoList)
        } else {
            ApiResponse.Error(response.message())
        }
    }
}