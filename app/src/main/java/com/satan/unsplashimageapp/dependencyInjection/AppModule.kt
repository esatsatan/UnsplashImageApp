package com.satan.unsplashimageapp.dependencyInjection

import com.satan.unsplashimageapp.constants.Constants
import com.satan.unsplashimageapp.constants.Constants.BASE_URL
import com.satan.unsplashimageapp.data.remote.UnsplashImageApi
import com.satan.unsplashimageapp.data.repository.UnsplashRepositoryImp
import com.satan.unsplashimageapp.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUnsplashApi() : UnsplashImageApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UnsplashImageApi::class.java)
    }

    @Provides
    @Singleton
    fun provideImageRepository(api: UnsplashImageApi) : ImageRepository {
        return UnsplashRepositoryImp(api)
    }

    
}