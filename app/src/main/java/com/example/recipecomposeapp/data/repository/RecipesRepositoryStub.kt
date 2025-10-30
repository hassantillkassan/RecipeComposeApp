package com.example.recipecomposeapp.data.repository

import android.content.Context
import com.example.recipecomposeapp.data.model.CategoryDto
import com.example.recipecomposeapp.data.model.RecipeDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okio.IOException

class RecipesRepositoryStub(private val context: Context) {

    private val gson = Gson()

    private val cachedCategories: List<CategoryDto> by lazy {
        try {
            val jsonString: String = context.assets.open("category.json")
                .bufferedReader()
                .use { it.readText() }
            val listType = object : TypeToken<List<CategoryDto>>() {}.type
            gson.fromJson(jsonString,listType)
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }

    private val cachedRecipes: List<RecipeDto> by lazy {
        try {
            val jsonString: String = context.assets.open("recipe.json")
                .bufferedReader()
                .use { it.readText() }
            val listType = object : TypeToken<List<RecipeDto>>() {}.type
            gson.fromJson(jsonString,listType)
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }

    fun getCategories(): List<CategoryDto> {
        return cachedCategories
    }

    fun getRecipesByCategoryId(categoryId: Int): List<RecipeDto> {
        return cachedRecipes
    }

}