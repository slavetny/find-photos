package com.slavetny.findphotos.di.module

import com.slavetny.findphotos.data.repository.PhotoRepository
import com.slavetny.findphotos.data.repository.PhotoRepositoryImpl
import com.slavetny.findphotos.presentation.screen.photosearch.PhotoSearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PhotoSearchViewModel(get(), get(), get()) }
    single { PhotoRepositoryImpl(get(), get()) as PhotoRepository }
}