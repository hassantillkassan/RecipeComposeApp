package com.example.recipecomposeapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipecomposeapp.core.ui.navigation.BottomNavigation
import com.example.recipecomposeapp.ui.categories.CategoriesScreen
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
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) { Text("Избранное") }
                }
                ScreenId.CATEGORIES -> {
                    CategoriesScreen()
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