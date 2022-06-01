package com.stockbit.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_crypto")
data class CryptoEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "full_name")
    val fullName: String? = null,

    @ColumnInfo(name = "last_day_change")
    val lastDayChange: Double? = null,

    @ColumnInfo(name = "last_day_percent_change")
    val lastDayPercentChange: Double? = null,

    @ColumnInfo(name = "symbol")
    val symbol: String? = null
)