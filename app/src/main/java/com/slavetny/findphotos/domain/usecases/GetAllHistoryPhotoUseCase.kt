package com.slavetny.findphotos.domain.usecases

import com.slavetny.findphotos.data.repository.PhotoRepository

class GetAllHistoryPhotoUseCase(
    private val repository: PhotoRepository
) {
    suspend operator fun invoke() =
        repository.getAllPhotoHistory()
}