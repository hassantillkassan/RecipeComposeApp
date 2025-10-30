package com.example.recipecomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.recipecomposeapp.data.repository.RecipesRepositoryStub

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repositoryStub = RecipesRepositoryStub(applicationContext)

        val categories = repositoryStub.getCategories()
        val recipes = repositoryStub.getRecipesByCategoryId(0)

        Log.d("REPO_STUB", "Загруженые категории: $categories")
        Log.d("REPO_STUB", "Загруженный рецепт: $recipes")

        enableEdgeToEdge()

        setContent {
            RecipesApp()
        }
    }
}