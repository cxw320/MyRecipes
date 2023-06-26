package com.example.myrecipes.repository

import android.content.Context
import com.example.myrecipes.api.ApiService
import com.example.myrecipes.api.SpoonacularApi
import com.example.myrecipes.api.responsemodel.RecipeDTO
import com.example.myrecipes.model.Recipe

class RecipeRepository {

    suspend fun getRandomRecipes(): List<Recipe> {
        return SpoonacularApi.apiService.getRandomRecipes().recipes.map {
            mapToRecipe(it)
        }
    }

    fun mapToRecipe(recipeDTO: RecipeDTO): Recipe {
        return Recipe(
            id = recipeDTO.id,
            recipeName = recipeDTO.recipeName,
            imageUrl = recipeDTO.imageUrl ?: "",
            summary = recipeDTO.summary
        )
    }
}