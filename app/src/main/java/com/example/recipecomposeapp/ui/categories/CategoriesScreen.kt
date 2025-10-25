package com.example.recipecomposeapp.ui.categories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.ui.theme.RecipesAppTheme

@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        ScreenHeader(
            text = "Категория",
            backgroundImageRes = R.drawable.bcg_categories,
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Список категорий")
        }
    }
}

@Preview
@Composable
fun CategoriesScreenPreview() {
    RecipesAppTheme {
        CategoriesScreen()
    }
}