package com.example.recipecomposeapp.ui.recipes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.core.ui.ScreenHeader

@Composable
fun RecipesScreen(contentPadding: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize()) {
        ScreenHeader(
            title = "Рецепт",
            backgroundImageRes = R.drawable.bcg_categories
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            contentAlignment = Alignment.Center,
        ) {
            Text("Скоро здесь будет список рецептов")
        }
    }
}