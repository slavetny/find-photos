package com.slavetny.findphotos.data.repository

import com.slavetny.findphotos.data.db.HistoryPhoto
import com.slavetny.findphotos.data.db.HistoryPhotoDao
import com.slavetny.findphotos.data.network.PhotoService
import com.slavetny.findphotos.data.network.Result
import com.slavetny.findphotos.domain.constants.API_KEY

class PhotoRepositoryImpl(
    private val photoService: PhotoService,
    private val historyPhotoDao: HistoryPhotoDao
) : PhotoRepository {

    override suspend fun getPhotoByName(name: String) =
        Result(photoService.getPhotoByName(API_KEY, name), NullPointerException("No results found..."))

    override suspend fun getAllPhotoHistory() =
        Result(historyPhotoDao.getAll())

    override suspend fun insertPhotoHistory(historyPhoto: HistoryPhoto) {
        historyPhotoDao.add(historyPhoto)
    }
}