package com.example.myapplication.di

import android.app.Application
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.Module




class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(ModuleRepos.myModule))
        }
    }


}