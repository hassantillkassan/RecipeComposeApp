package com.example.recipecomposeapp.ui.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.ui.recipes.model.IngredientUiModel
import com.example.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.example.recipecomposeapp.ui.theme.RecipesAppTheme

@Composable
fun RecipeDetailsScreen(
    contentPadding: PaddingValues,
    recipe: RecipeUiModel,
) {
    val bottomPadding = contentPadding.calculateBottomPadding()

    Column(modifier = Modifier.fillMaxSize()) {
        ScreenHeader(
            title = recipe.title,
            backgroundImageModel = recipe.imageUrl,
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 16.dp + bottomPadding),
        ) {
            item {
                Text(
                    "Ингредиенты".uppercase(),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.displayLarge,
                )
            }
            items(recipe.ingredients) { ingredient ->
                Text("${ingredient.name}: ${ingredient.amount}")
            }
            item {
                Text(
                    "Способ приготовления".uppercase(),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.displayLarge,
                )
            }
            items(recipe.method) { step ->
                Text(step)
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun RecipeDetailsScreenPreview() {
    RecipesAppTheme {
        RecipeDetailsScreen(
            contentPadding = PaddingValues(0.dp),
            recipe = RecipeUiModel(
                id = 0,
                title = "Классический бургер с говядиной",
                imageUrl = "",
                isFavorite = false,

                ingredients = listOf(
                    IngredientUiModel("говяжий фарш", "0.5 кг"),
                    IngredientUiModel("луковица, мелко нарезанная", "1 шт"),
                    IngredientUiModel("чеснок, измельченный", "2 зубч")
                ),

                method = listOf(
                    "1. В глубокой миске смешайте говяжий фарш, лук, чеснок, соль и перец. Разделите фарш на 4 равные части и сформируйте котлеты.",
                    "2. Разогрейте сковороду на среднем огне. Обжаривайте котлеты с каждой стороны в течение 4-5 минут или до желаемой степени прожарки.",
                    "3. В то время как котлеты готовятся, подготовьте булочки. Разрежьте их пополам и обжарьте на сковороде до золотистой корочки.",
                )
            )
        )
    }
}