package com.stockbit.local.source

import com.stockbit.local.dao.CryptoDao
import com.stockbit.local.dao.RemoteKeyDao
import com.stockbit.local.entity.CryptoEntity
import com.stockbit.local.entity.RemoteKeyEntity

class CryptoLocalDataSource(
    private val cryptoDao: CryptoDao,
    private val remoteKeyDao: RemoteKeyDao
) {
    suspend fun isNotEmpty(): Boolean {
        return cryptoDao.getCrypto().isNotEmpty()
    }

    suspend fun getKeys() = remoteKeyDao.getKeys()

    suspend fun updateKey(
        nextKey: Int,
        endOfPaginationReached: Boolean,
        cryptoList: List<CryptoEntity>
    ) {
        try {
            remoteKeyDao.insert(
                RemoteKeyEntity(
                    0,
                    nextKey = nextKey,
                    isEndReached = endOfPaginationReached
                )
            )
            cryptoDao.insert(cryptoList)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getCryptos() = cryptoDao.getCryptos()
}