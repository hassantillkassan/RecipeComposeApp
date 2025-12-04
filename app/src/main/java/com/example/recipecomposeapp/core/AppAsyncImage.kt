package com.example.recipecomposeapp.core

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.recipecomposeapp.R

@Composable
fun AppAsyncImage(
    model: Any?,
    contentDescription: String,
    modifier: Modifier = Modifier,
    placeholder: Painter = painterResource(R.drawable.img_placeholder),
    error: Painter = painterResource(R.drawable.img_error),
    contentScale: ContentScale = ContentScale.Crop,
) {
    val isPreview = LocalInspectionMode.current

    if (isPreview) {
        if (model is Int) {
            Image(
                painter = painterResource(model),
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
            )
        } else {
            Image(
                painter = painterResource(R.drawable.preview_burger),
                contentDescription = contentDescription,
                modifier = modifier,
                contentScale = contentScale,
            )
        }
    } else {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(model)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            modifier = modifier,
            placeholder = placeholder,
            error = error,
            contentScale = contentScale
        )
    }
}