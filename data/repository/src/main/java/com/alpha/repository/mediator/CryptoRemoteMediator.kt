package com.alpha.repository.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.alpha.local.entity.CryptoEntity
import com.alpha.local.entity.RemoteKeyEntity
import com.alpha.local.source.CryptoLocalDataSource
import com.alpha.remote.source.CryptoRemoteDatasource
import com.alpha.remote.utils.ApiResponse
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class CryptoRemoteMediator(
    private val remoteDatasource: CryptoRemoteDatasource,
    private val localDataSource: CryptoLocalDataSource
) : RemoteMediator<Int, CryptoEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CryptoEntity>
    ): MediatorResult {
        try {
            val key = when (loadType) {
                LoadType.REFRESH -> {
                    if (localDataSource.isNotEmpty()) return MediatorResult.Success(false)
                    null
                }
                LoadType.PREPEND -> {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                LoadType.APPEND -> {
                    getKey()
                }
            }

            if (key != null) {
                if (key.isEndReached) return MediatorResult.Success(endOfPaginationReached = true)
            }

            val page: Int = key?.nextKey ?: DEFAULT_PAGE
            when (val response = remoteDatasource.fetchTopUsersAsync(page, DEFAULT_SYMBOL)) {
                is ApiResponse.Success -> {
                    val cryptoList = response.data?.map {
                        CryptoEntity(
                            id = it.coinInfo?.id.orEmpty(),
                            name = it.coinInfo?.name,
                            fullName = it.coinInfo?.fullName,
                            lastDayChange = it.display?.currency?.lastDayChange,
                            lastDayPercentChange = it.display?.currency?.lastDayPercentChange,
                            price = it.display?.currency?.price
                        )
                    }
                    val endOfPaginationReached =
                        cryptoList.isNullOrEmpty()

                    val nextKey = page + 1
                    localDataSource.updateKey(nextKey, endOfPaginationReached, cryptoList.orEmpty())
                    return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
                }
                is ApiResponse.Error -> {
                    return MediatorResult.Error(Exception(response.errorMessage))
                }
                else -> {
                    return MediatorResult.Error(Exception("no data"))
                }
            }
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: Exception) {
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getKey(): RemoteKeyEntity? {
        return localDataSource.getKeys().firstOrNull()
    }

    companion object {
        private const val DEFAULT_PAGE = 1
        private const val DEFAULT_SYMBOL = "IDR"
    }
}