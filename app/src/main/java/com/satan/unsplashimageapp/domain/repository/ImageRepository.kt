package com.satan.unsplashimageapp.domain.repository

import com.satan.unsplashimageapp.domain.model.Photo
import com.satan.unsplashimageapp.domain.model.PhotoDetail

interface ImageRepository {

    suspend fun getAllImages() : List<Photo>

    suspend fun getImageDetail(id : String) : PhotoDetail
}