package com.slavetny.findphotos.data.db

interface HistoryPhotoDao {
    fun add(historyPhoto: HistoryPhoto): Boolean
    fun getAll(): List<HistoryPhoto>
}