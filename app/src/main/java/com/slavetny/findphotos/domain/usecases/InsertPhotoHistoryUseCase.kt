package com.slavetny.findphotos.domain.usecases

import com.slavetny.findphotos.data.db.HistoryPhoto
import com.slavetny.findphotos.data.repository.PhotoRepository

class InsertPhotoHistoryUseCase(
    private val repository: PhotoRepository
) {
    suspend operator fun invoke(historyPhoto: HistoryPhoto) =
        repository.insertPhotoHistory(historyPhoto)
}