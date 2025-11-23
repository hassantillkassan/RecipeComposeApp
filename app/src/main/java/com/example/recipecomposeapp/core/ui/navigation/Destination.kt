package com.example.recipecomposeapp.core.ui.navigation

sealed class Destination(val route: String) {

    object Categories: Destination("categories")

    object Favorites: Destination("favorite")

    object Recipes: Destination("recipes/{categoryId}") {
        fun createRoute(categoryId: Int) = "recipes/$categoryId"
    }

    object RecipeDetails: Destination("recipe_details/{recipeId}") {
        fun createRoute(recipeId: Int) = "recipe_details/{$recipeId}"
    }
}