package com.alpha.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alpha.local.converter.Converters
import com.alpha.local.dao.CryptoDao
import com.alpha.local.dao.RemoteKeyDao
import com.alpha.local.entity.CryptoEntity
import com.alpha.local.entity.RemoteKeyEntity

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