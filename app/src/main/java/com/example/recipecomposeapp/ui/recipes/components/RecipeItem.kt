package com.example.recipecomposeapp.ui.recipes.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipecomposeapp.core.AppAsyncImage
import com.example.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.example.recipecomposeapp.ui.theme.RecipesAppTheme

@Composable
fun RecipeItem(
    recipe: RecipeUiModel,
    modifier: Modifier = Modifier,
    onRecipeClick: (Int, RecipeUiModel) -> Unit = { _, _ -> },
    ) {

    Card(
        modifier = modifier.clickable{ onRecipeClick(recipe.id, recipe) },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ) {
        Column {
            AppAsyncImage(
                model = recipe.imageUrl,
                contentDescription = recipe.title,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
            )
            Text(
                text = recipe.title.uppercase(),
                modifier = Modifier.padding(8.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeItemPreview() {
    RecipesAppTheme {
        RecipeItem(
            RecipeUiModel(
                id = 0,
                title = "Классический бургер с говядиной",
                imageUrl = "",
                ingredients = listOf(),
                method = listOf(),
                isFavorite = true,
            )
        )
    }
}