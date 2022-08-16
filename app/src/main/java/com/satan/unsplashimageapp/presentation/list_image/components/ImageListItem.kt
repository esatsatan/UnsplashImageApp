package com.satan.unsplashimageapp.presentation.list_image.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.satan.unsplashimageapp.domain.model.Photo
import com.satan.unsplashimageapp.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ImageListItem(
    photo : Photo,
    OnItemClick : (Photo) -> Unit
) {
    val painter = rememberImagePainter(data = photo.urls.regular) {
        crossfade(durationMillis = 1000)
        error(R.drawable.ic_placeholder)
        placeholder(R.drawable.ic_placeholder)
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { OnItemClick(photo) }
        .height(300.dp)
        .padding(10.dp))
    {
        
        Image(
            painter = painter,
            contentDescription = "Unsplash Image",
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .alpha(ContentAlpha.medium),
            color = Color.Black
        ) {}

        Row(modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = photo.user.name,
                color = Color.Black,
                fontSize = MaterialTheme.typography.caption.fontSize,
            )

        }


    }

}