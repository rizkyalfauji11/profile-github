package com.stockbit.repository

import androidx.paging.*
import com.stockbit.local.entity.CryptoEntity
import com.stockbit.local.source.CryptoLocalDataSource
import com.stockbit.model.CryptoModel
import com.stockbit.remote.source.CryptoRemoteDatasource
import com.stockbit.repository.mediator.CryptoRemoteMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface CryptoRepository {
     fun getCrypto(): Flow<PagingData<CryptoModel>>
}

class CryptoRepositoryImpl(
    private val remoteDataSource: CryptoRemoteDatasource,
    private val localDataSource: CryptoLocalDataSource
) : CryptoRepository {

    @OptIn(ExperimentalPagingApi::class)
    private fun fetchCryptos(): Flow<PagingData<CryptoEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = CryptoRemoteMediator(
                remoteDataSource, localDataSource
            ),
            pagingSourceFactory = { localDataSource.getCryptos() }
        ).flow
    }

    override fun getCrypto(): Flow<PagingData<CryptoModel>> {
        val data = fetchCryptos().map {
            it.map { crypto ->
                CryptoModel(
                    id = crypto.id,
                    name = crypto.name,
                    fullName = crypto.fullName,
                    lastDayChange = crypto.lastDayChange,
                    lastDayPercentChange = crypto.lastDayPercentChange,
                    price = crypto.price,
                )
            }
        }
        return data
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 10
    }
}