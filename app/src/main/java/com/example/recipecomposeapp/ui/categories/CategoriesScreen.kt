package com.example.recipecomposeapp.ui.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipecomposeapp.R
import com.example.recipecomposeapp.core.ui.ScreenHeader
import com.example.recipecomposeapp.data.repository.RecipesRepositoryStub
import com.example.recipecomposeapp.ui.categories.components.CategoryItem
import com.example.recipecomposeapp.ui.categories.model.CategoryUiModel
import com.example.recipecomposeapp.ui.categories.model.toUiModel
import com.example.recipecomposeapp.ui.theme.RecipesAppTheme

@Composable
fun CategoriesScreen(
    contentPadding: PaddingValues,
    onCategoryClick: (categoryId: Int, categoryTitle: String) -> Unit = { _, _ -> }
) {
    val bottomPadding = contentPadding.calculateBottomPadding()

    val context = LocalContext.current

    val repository = remember { RecipesRepositoryStub(context) }

    val categories: List<CategoryUiModel> = remember {
        repository.getCategories().map { it.toUiModel() }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        ScreenHeader(
            title = "Категория",
            backgroundImageRes = R.drawable.bcg_categories,
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 16.dp + bottomPadding)
        ) {
            items(
                items = categories,
                key = { category -> category.id }
            ) { category ->
                CategoryItem(
                    category = category,
                    onCategoryClick = onCategoryClick
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CategoriesScreenPreview() {
    RecipesAppTheme {
        CategoriesScreen(
            contentPadding = PaddingValues(0.dp),
            onCategoryClick = {_, _ ->}
        )
    }
}