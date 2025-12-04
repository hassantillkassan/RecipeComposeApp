package com.example.recipecomposeapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipecomposeapp.core.ui.navigation.BottomNavigation
import com.example.recipecomposeapp.core.ui.navigation.Destination
import com.example.recipecomposeapp.core.ui.navigation.KEY_RECIPE_OBJECT
import com.example.recipecomposeapp.ui.categories.CategoriesScreen
import com.example.recipecomposeapp.ui.favorites.FavoritesScreen
import com.example.recipecomposeapp.ui.recipes.RecipeDetailsScreen
import com.example.recipecomposeapp.ui.recipes.RecipesScreen
import com.example.recipecomposeapp.ui.recipes.model.RecipeUiModel
import com.example.recipecomposeapp.ui.theme.RecipesAppTheme

@Composable
fun RecipesApp(darkTheme: Boolean = isSystemInDarkTheme()) {

    val navController = rememberNavController()


    RecipesAppTheme(darkTheme = darkTheme) {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    onFavoriteClick = {
                        navController.navigate(Destination.Favorites.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    onCategoriesClick = {
                        navController.navigate(Destination.Categories.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        ) { innerPadding ->

            NavHost(
                navController = navController,
                startDestination = Destination.Categories.route
            ) {
                composable(
                    route = Destination.Categories.route
                ) {
                    CategoriesScreen(
                        contentPadding = innerPadding,
                        onCategoryClick = { categoryId, _ ->
                            navController.navigate(Destination.Recipes.createRoute(categoryId))
                        }
                    )
                }
                composable(
                    route = Destination.Recipes.route,
                    arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
                    RecipesScreen(
                        contentPadding = innerPadding,
                        categoryId = categoryId,
                        categoryTitle = "",
                        onRecipeClick = { recipeId, recipe ->
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                KEY_RECIPE_OBJECT,
                                recipe
                            )
                            navController.navigate(Destination.RecipeDetails.createRoute(recipeId))
                        }
                    )
                }
                composable(
                    route = Destination.RecipeDetails.route,
                    arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
                ) {
                    val recipe =
                        navController.previousBackStackEntry?.savedStateHandle?.get<RecipeUiModel>(
                            KEY_RECIPE_OBJECT
                        )
                    if (recipe != null) {
                        RecipeDetailsScreen(
                            contentPadding = innerPadding,
                            recipe = recipe,
                        )
                    }
                }
                composable(
                    route = Destination.Favorites.route
                ) {
                    FavoritesScreen(contentPadding = innerPadding)
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