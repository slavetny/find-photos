package com.slavetny.findphotos.domain.usecases

import com.slavetny.findphotos.data.repository.PhotoRepository

class GetPhotoByNameUseCase(
    private val repository: PhotoRepository
) {
    suspend operator fun invoke(name: String) =
        repository.getPhotoByName(name)
}