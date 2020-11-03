package com.slavetny.findphotos.di.module

import com.slavetny.findphotos.data.db.HistoryPhotoDao
import com.slavetny.findphotos.data.db.HistoryPhotoDaoImpl
import org.koin.dsl.module

val databaseModule = module {
    single { providePhotoDao() as HistoryPhotoDao }
}

fun providePhotoDao() =
    HistoryPhotoDaoImpl()