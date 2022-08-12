package com.satan.unsplashimageapp.data.repository

import com.satan.unsplashimageapp.data.remote.UnsplashImageApi
import com.satan.unsplashimageapp.domain.model.Photo
import com.satan.unsplashimageapp.domain.model.PhotoDetail
import com.satan.unsplashimageapp.domain.repository.ImageRepository
import javax.inject.Inject

class UnsplashRepositoryImp @Inject constructor(
    private val api : UnsplashImageApi
) : ImageRepository {

    override suspend fun getAllImages(): List<Photo> {
       return api.getAllImages()
    }

    override suspend fun getImageDetail(id: String): PhotoDetail {
        return api.getImageDetail(id)
    }

}