package com.alpha.hiring.di

import com.alpha.local.di.localModule
import com.alpha.remote.di.createRemoteModule
import com.alpha.repository.di.repositoryModule
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