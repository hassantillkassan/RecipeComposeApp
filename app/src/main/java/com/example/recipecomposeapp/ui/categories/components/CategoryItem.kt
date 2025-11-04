package com.example.recipecomposeapp.ui.categories.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.ui.categories.model.CategoryUiModel
import com.example.recipecomposeapp.ui.theme.RecipesAppTheme

@Composable
fun CategoryItem(
    category: CategoryUiModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(category.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = category.title,
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.img_placeholder),
                error = painterResource(R.drawable.img_error)
            )
            Text(
                text = category.title.uppercase(),
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = category.description,
                modifier = Modifier.padding(8.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodySmall,
                minLines = 3,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    RecipesAppTheme {
        CategoryItem(
            CategoryUiModel(
                id = 0,
                title = "Бургеры",
                description = "Рецепты всех популярных видов бургеров",
                imageUrl = ""
            )
        )
    }
}