package com.slavetny.findphotos.data.network

import com.slavetny.findphotos.domain.model.Photo
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {

    @GET("search/photos?&query=dude")
    suspend fun getPhotoByName(@Query("client_id") clientId: String,
                               @Query("query") query: String): Photo

}