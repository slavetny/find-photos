package com.slavetny.findphotos.di.module

import com.slavetny.findphotos.data.network.PhotoService
import com.slavetny.findphotos.domain.constants.BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit() }
    single { providePhotoService(get()) }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun providePhotoService(retrofit: Retrofit):
        PhotoService = retrofit.create(PhotoService::class.java)