package com.satan.unsplashimageapp.data.remote

import retrofit2.http.GET

interface UnsplashImageApi {

    @GET
    suspend fun getRandomImages()
}