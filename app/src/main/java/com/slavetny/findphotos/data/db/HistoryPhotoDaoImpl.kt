package com.slavetny.findphotos.data.db

import android.util.Log
import io.realm.Realm

class HistoryPhotoDaoImpl : HistoryPhotoDao {
    override fun add(historyPhoto: HistoryPhoto): Boolean {
        return try {
            val realm = Realm.getDefaultInstance()
            realm.executeTransaction{realm1 ->
                realm1.insertOrUpdate(historyPhoto)
            }

            realm.close()
            true
        } catch (e: Exception) {
            Log.d("Adding Exception", e.message!!)
            false
        }
    }

    override fun getAll(): List<HistoryPhoto> {
        val realm = Realm.getDefaultInstance()
        val list =  realm.copyFromRealm(realm.where(HistoryPhoto::class.java).findAll())
        realm.close()
        return list
    }
}