package com.stockbit.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stockbit.local.entity.RemoteKeyEntity

@Dao
interface RemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKey(remoteKey: RemoteKeyEntity)

    @Query("SELECT * FROM tb_remote_key")
    suspend fun getKeys(): List<RemoteKeyEntity>
}