package com.satan.unsplashimageapp.presentation.list_image

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satan.unsplashimageapp.constants.Resource
import com.satan.unsplashimageapp.domain.use_case.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val getPhotosUseCase : GetPhotosUseCase
 ) : ViewModel() {

     private val _state = mutableStateOf(PhotoListState())
     val state : State<PhotoListState> = _state

    init {
        getPhotoList()
    }

    private fun getPhotoList() {
        getPhotosUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                  _state.value = PhotoListState(photos = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PhotoListState(error = result.message ?: "Beklenmeyen Hata !")
                }
                is Resource.Loading -> {
                    _state.value = PhotoListState(isLoading = true)
                }
             }
        }
            .launchIn(viewModelScope)
    }

}