package com.stockbit.local.dao

import androidx.room.*
import com.stockbit.local.entity.CryptoEntity
import com.stockbit.local.entity.RemoteKeyEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RemoteKeyDao{
    @Query("SELECT * FROM tb_remote_key")
    abstract suspend fun getKeys(): Array<RemoteKeyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(data: RemoteKeyEntity)

    @Query("DELETE FROM tb_remote_key")
    abstract fun clear()
}