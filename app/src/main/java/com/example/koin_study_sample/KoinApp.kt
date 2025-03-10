package com.example.koin_study_sample

import android.app.Application
import com.example.koin_study_sample.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApp)
            androidLogger()
            modules(
                appModule()
            )
        }
    }
}