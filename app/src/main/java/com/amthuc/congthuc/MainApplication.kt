package com.amthuc.congthuc

import android.app.Application
import com.amthuc.congthuc.di.appModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, appModule)
    }
}