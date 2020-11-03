package com.slavetny.findphotos.data.db

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class HistoryPhoto(
    @PrimaryKey
    var id: String = "",
    var photoUrl: String = "",
    var keyWord: String = ""
) : RealmObject()