package com.devapps.justspeak

import android.app.Application
import com.devapps.justspeak.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class JustSpeakApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@JustSpeakApplication)
            modules(appModule)
        }
    }
}