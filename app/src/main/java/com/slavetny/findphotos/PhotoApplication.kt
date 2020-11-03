package com.slavetny.findphotos

import android.app.Application
import com.slavetny.findphotos.di.module.databaseModule
import com.slavetny.findphotos.di.module.networkModule
import com.slavetny.findphotos.di.module.useCaseModule
import com.slavetny.findphotos.di.module.viewModelModule
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PhotoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this@PhotoApplication)
        val config = RealmConfiguration.Builder()
            .name("photo_history")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)

        startKoin {
            androidContext(this@PhotoApplication)
            androidLogger()
            modules(
                listOf(
                    viewModelModule, networkModule, databaseModule, useCaseModule
                )
            )
        }
    }
}