package com.stockbit.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract suspend fun insert(entities: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract suspend fun insert(entity: T)

}