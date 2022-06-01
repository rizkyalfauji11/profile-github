package com.stockbit.hiring.di

import com.stockbit.local.di.localModule
import com.stockbit.remote.di.createRemoteModule
import com.stockbit.repository.di.repositoryModule
import id.alpha.code.auth.di.featureAuthModule
import id.alpha.code.main.di.featureHomeModule

val appComponent =
    listOf(
        createRemoteModule("https://min-api.cryptocompare.com/"),
        repositoryModule,
        localModule,
        featureHomeModule,
        featureAuthModule
    )