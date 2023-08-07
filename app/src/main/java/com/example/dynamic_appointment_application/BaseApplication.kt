package com.example.dynamic_appointment_application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {
    //push test
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@BaseApplication)
            androidLogger(level = Level.ERROR)
            modules(
                listOf(
                    repositoryModule,
                    useCaseModule,
                    utilsModule,
                    viewModelModule,
                )
            )
        }
    }
}