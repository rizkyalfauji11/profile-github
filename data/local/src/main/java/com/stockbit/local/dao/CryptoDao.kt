package com.stockbit.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.stockbit.local.entity.CryptoEntity

@Dao
abstract class CryptoDao : BaseDao<CryptoEntity>() {

    @Query("SELECT * FROM tb_crypto WHERE name = :name LIMIT 1")
    abstract suspend fun getCrypto(name: String): CryptoEntity?

    @Query("SELECT COUNT(id) from tb_crypto")
    abstract suspend fun count(): Int

    @Query("SELECT * FROM tb_crypto")
    abstract fun getCryptos(): PagingSource<Int, CryptoEntity>

    suspend fun save(data: CryptoEntity) {
        insert(data)
    }

    suspend fun save(list: List<CryptoEntity>) {
        insert(list)
    }
}