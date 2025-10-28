package com.example.recipecomposeapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipecomposeapp.core.ui.navigation.BottomNavigation
import com.example.recipecomposeapp.ui.categories.CategoriesScreen
import com.example.recipecomposeapp.ui.favorites.FavoritesScreen
import com.example.recipecomposeapp.ui.recipes.RecipesScreen
import com.example.recipecomposeapp.ui.theme.RecipesAppTheme

@Composable
fun RecipesApp(darkTheme: Boolean = isSystemInDarkTheme()) {

    var currentScreen by remember { mutableStateOf(ScreenId.CATEGORIES) }

    RecipesAppTheme(darkTheme = darkTheme) {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    onFavoriteClick = { currentScreen = ScreenId.FAVORITES },
                    onCategoriesClick = { currentScreen = ScreenId.CATEGORIES }
                )
            }
        ) { innerPadding ->

            when (currentScreen) {
                ScreenId.FAVORITES -> {
                    FavoritesScreen(innerPadding)
                }
                ScreenId.CATEGORIES -> {
                    CategoriesScreen(innerPadding)
                }
                ScreenId.RECIPES -> {
                    RecipesScreen(innerPadding)
                }
            }
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RecipesAppPreviewLight() {
    RecipesApp()
}

@Preview(
    name = "Dark Mode",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RecipesAppPreviewDark() {
    RecipesApp(true)
}