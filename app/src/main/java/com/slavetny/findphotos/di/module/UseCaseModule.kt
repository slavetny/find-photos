package com.slavetny.findphotos.di.module

import com.slavetny.findphotos.domain.usecases.GetAllHistoryPhotoUseCase
import com.slavetny.findphotos.domain.usecases.GetPhotoByNameUseCase
import com.slavetny.findphotos.domain.usecases.InsertPhotoHistoryUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetPhotoByNameUseCase(get()) }
    single { InsertPhotoHistoryUseCase(get()) }
    single { GetAllHistoryPhotoUseCase(get()) }
}