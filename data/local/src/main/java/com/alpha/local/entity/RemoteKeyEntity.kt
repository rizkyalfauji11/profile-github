package com.alpha.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_remote_key")
data class RemoteKeyEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "next_key")
    val nextKey: Int?,
    @ColumnInfo(name = "is_end_reached")
    val isEndReached: Boolean
)
