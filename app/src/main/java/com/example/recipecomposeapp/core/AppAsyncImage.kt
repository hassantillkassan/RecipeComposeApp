package com.example.recipecomposeapp.core

import androidx.annotation.DrawableRes
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
    imageUrl: String,
    @DrawableRes previewRes: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    placeholder: Painter = painterResource(R.drawable.img_placeholder),
    error: Painter = painterResource(R.drawable.img_error),
    contentScale: ContentScale = ContentScale.Crop,
) {
    val isPreview = LocalInspectionMode.current

    if (isPreview) {
        Image(
            painter = painterResource(previewRes),
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
        )
    } else {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
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