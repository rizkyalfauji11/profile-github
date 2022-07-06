package com.alpha.hiring

import android.app.Application
import com.alpha.hiring.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // CONFIGURATION ---
    open fun configureDi() =
        startKoin {
            androidContext(this@App)
            modules(provideComponent())
        }

    // PUBLIC API ---
    open fun provideComponent() = appComponent
}