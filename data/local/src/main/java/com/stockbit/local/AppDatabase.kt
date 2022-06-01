package com.stockbit.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.stockbit.local.converter.Converters
import com.stockbit.local.dao.CryptoDao
import com.stockbit.local.dao.RemoteKeyDao
import com.stockbit.local.entity.CryptoEntity
import com.stockbit.local.entity.RemoteKeyEntity

@Database(
    entities = [CryptoEntity::class, RemoteKeyEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cryptoDao(): CryptoDao
    abstract fun remoteKeyDao(): RemoteKeyDao

    companion object {

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "App.db"
            )
                .build()
    }
}