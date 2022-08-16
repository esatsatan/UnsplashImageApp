package com.satan.unsplashimageapp.presentation.list_image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.satan.unsplashimageapp.Screen
import com.satan.unsplashimageapp.presentation.list_image.components.ImageListItem

@Composable
fun PhotoListScreen(
    navController: NavController,
    viewModel: PhotoListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(state.photos){ photo ->
                ImageListItem(
                    photo = photo,
                    OnItemClick = {
                        navController.navigate(Screen.PhotoDetailScreen.route + "/${photo.id}")
                    }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(text = state.error, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.Center),
                color = MaterialTheme.colors.error, textAlign = TextAlign.Center
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}