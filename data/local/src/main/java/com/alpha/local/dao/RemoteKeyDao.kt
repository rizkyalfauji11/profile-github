package com.alpha.local.dao

import androidx.room.*
import com.alpha.local.entity.RemoteKeyEntity

@Dao
abstract class RemoteKeyDao{
    @Query("SELECT * FROM tb_remote_key")
    abstract suspend fun getKeys(): Array<RemoteKeyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(data: RemoteKeyEntity)

    @Query("DELETE FROM tb_remote_key")
    abstract fun clear()
}