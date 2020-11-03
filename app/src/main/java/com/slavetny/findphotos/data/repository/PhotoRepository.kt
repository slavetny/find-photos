package com.slavetny.findphotos.data.repository

import com.slavetny.findphotos.data.network.Result
import com.slavetny.findphotos.domain.model.Photo

interface PhotoRepository {
    suspend fun getPhotoByName(name: String): Result<Photo>
    suspend fun insertPhotoHistory(historyPhoto: com.slavetny.findphotos.data.db.HistoryPhoto)
    suspend fun getAllPhotoHistory(): Result<List<com.slavetny.findphotos.data.db.HistoryPhoto>>
}