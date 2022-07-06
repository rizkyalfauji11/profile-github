package com.alpha.local.di

import com.alpha.local.AppDatabase
import com.alpha.local.source.CryptoLocalDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val DATABASE = "DATABASE"

val localModule = module {
    single(named(DATABASE)) { AppDatabase.buildDatabase(androidContext()) }
    factory { (get(named(DATABASE)) as AppDatabase).cryptoDao() }
    factory { (get(named(DATABASE)) as AppDatabase).remoteKeyDao() }
    factory { CryptoLocalDataSource(get(), get()) }
}