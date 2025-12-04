package com.example.recipecomposeapp.ui.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.ui.theme.RecipesAppTheme

@Composable
fun FavoritesScreen(contentPadding: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize()) {
        ScreenHeader(
            title = "Избранное",
            backgroundImageModel = R.drawable.bcg_favorites
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            contentAlignment = Alignment.Center,
        ) {
            Text("Список избранных рецептов")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun FavoritesScreenPreview() {
    RecipesAppTheme {
        FavoritesScreen(PaddingValues(0.dp))
    }
}