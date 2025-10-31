package com.example.recipecomposeapp.data.model

data class RecipeDto(
    val id: Int,
    val categoryId: Int,
    val title: String,
    val ingredients: List<IngredientDto>,
    val method: List<String>,
    val imageUrl: String,
    val isFavorite: Boolean,
)