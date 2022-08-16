package com.satan.unsplashimageapp.data.remote

import com.satan.unsplashimageapp.domain.model.Photo
import com.satan.unsplashimageapp.domain.model.PhotoDetail
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface UnsplashImageApi {

    @Headers("Authorization: Client-ID EFxJKdAFSBBWITnqg74Zq_fOjzIQGooriWA5Xam1crA")
    @GET("/photos")
    suspend fun getAllImages() : List<Photo>


    @Headers("Authorization: Client-ID EFxJKdAFSBBWITnqg74Zq_fOjzIQGooriWA5Xam1crA")
    @GET("/photos/id")
    suspend fun getImageDetail(@Path("id") id : String) : PhotoDetail

}