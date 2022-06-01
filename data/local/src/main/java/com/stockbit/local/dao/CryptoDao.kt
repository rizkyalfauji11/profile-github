package com.stockbit.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stockbit.local.entity.CryptoEntity

@Dao
abstract class CryptoDao {
    @Query("SELECT id from tb_crypto")
    abstract suspend fun getCrypto(): Array<CryptoEntity>

    @Query("SELECT * FROM tb_crypto")
    abstract fun getCryptos(): PagingSource<Int, CryptoEntity>

    @Query("DELETE FROM tb_crypto")
    abstract fun clear()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(list: List<CryptoEntity>)
}