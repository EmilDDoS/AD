package com.example.ad.app

import android.app.Application
import com.example.ad.di.AppComponent
import com.example.ad.di.ApplicationModule
import com.example.ad.di.DaggerAppComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        componentApp = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var componentApp: AppComponent
    }
}