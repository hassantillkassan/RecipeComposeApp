package com.example.recipecomposeapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipecomposeapp.ui.theme.RecipesAppTheme

@Composable
fun RecipesApp(darkTheme: Boolean = isSystemInDarkTheme()) {

    RecipesAppTheme(darkTheme = darkTheme) {
        Scaffold { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
            ) {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
    )
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