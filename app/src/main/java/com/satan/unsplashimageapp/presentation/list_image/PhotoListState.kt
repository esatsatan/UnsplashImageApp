package com.satan.unsplashimageapp.presentation.list_image

import com.satan.unsplashimageapp.domain.model.Photo

data class PhotoListState(
    val isLoading : Boolean = false,
    val photos : List<Photo> = emptyList(),
    val error : String = ""
)
