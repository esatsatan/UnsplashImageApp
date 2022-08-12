package com.satan.unsplashimageapp.domain.use_case

import com.satan.unsplashimageapp.constants.Resource
import com.satan.unsplashimageapp.domain.model.PhotoDetail
import com.satan.unsplashimageapp.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    operator fun invoke(id : String) : Flow<Resource<PhotoDetail>> = flow {
        try {
            emit(Resource.Loading())
            val photoDetail = repository.getImageDetail(id)
            emit(Resource.Success(photoDetail))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Beklenmeyen Hata"))
        } catch (e : IOException) {
            emit(Resource.Error("İnternet Bağlantınızı kontrol ediniz."))
        }
    }
}