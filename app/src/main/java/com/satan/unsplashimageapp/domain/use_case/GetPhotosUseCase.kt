package com.satan.unsplashimageapp.domain.use_case

import com.satan.unsplashimageapp.constants.Resource
import com.satan.unsplashimageapp.domain.model.Photo
import com.satan.unsplashimageapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository : ImageRepository
) {

    operator fun invoke() : Flow<Resource<List<Photo>>> = flow {
        try {
            emit(Resource.Loading())
            val photos = repository.getAllImages()
            emit(Resource.Success(photos))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Beklenmeyen Hata!"))
        } catch (e : IOException) {
            emit(Resource.Error("Servera erişilemiyor. İnternet Bağlantınızı kontrol ediniz !! "))
        }
    }

}