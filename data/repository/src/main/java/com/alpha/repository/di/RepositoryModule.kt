package com.alpha.repository.di

import com.alpha.repository.AppDispatchers
import com.alpha.repository.CryptoRepository
import com.alpha.repository.CryptoRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { CryptoRepositoryImpl(get(), get()) as CryptoRepository }
}