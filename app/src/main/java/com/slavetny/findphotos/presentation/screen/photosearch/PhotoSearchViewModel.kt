package com.slavetny.findphotos.presentation.screen.photosearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.slavetny.findphotos.data.db.HistoryPhoto
import com.slavetny.findphotos.domain.model.Photo
import com.slavetny.findphotos.domain.usecases.GetAllHistoryPhotoUseCase
import com.slavetny.findphotos.domain.usecases.GetPhotoByNameUseCase
import com.slavetny.findphotos.domain.usecases.InsertPhotoHistoryUseCase
import com.slavetny.findphotos.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoSearchViewModel(
    private val getPhotoByNameUseCase: GetPhotoByNameUseCase,
    private val insertPhotoHistoryUseCase: InsertPhotoHistoryUseCase,
    private val getAllHistoryPhotoUseCase: GetAllHistoryPhotoUseCase
) : BaseViewModel() {

    private val _photoLiveData = MutableLiveData<Photo>()
    val photoLiveData: LiveData<Photo> get() = _photoLiveData

    private val _historyPhotoLiveData = MutableLiveData<List<HistoryPhoto>>()
    val historyPhotoLiveData: LiveData<List<HistoryPhoto>>
        get() = _historyPhotoLiveData

    init {
        getAllHistoryPhoto()
    }

    fun getPhotoByName(name: String) {
        if (name.isNotEmpty()) {
            viewModelScope.launch {
                runCatching {
                    getPhotoByNameUseCase.invoke(name)
                }.onSuccess {
                    if (it.value?.results?.size != 0) {
                        _photoLiveData.value = it.value
                    } else {
                        onHandleError(it.throwable?.message)
                    }
                }.onFailure {
                    onHandleError(it.message)
                }
            }
        } else {
            onHandleError("Uncorrected...")
        }
    }

    fun insertHistoryPhoto(id: String, url: String, keyWord: String) {
        viewModelScope.launch(Dispatchers.IO) {
            insertPhotoHistoryUseCase.invoke(HistoryPhoto(id, url, keyWord))
        }
    }

    fun getAllHistoryPhoto() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllHistoryPhotoUseCase.invoke()

            runCatching {
                getAllHistoryPhotoUseCase.invoke()
            }.onSuccess {
                _historyPhotoLiveData.postValue(it.value)
            }.onFailure {
                onHandleError(it.message)
            }
        }
    }
}