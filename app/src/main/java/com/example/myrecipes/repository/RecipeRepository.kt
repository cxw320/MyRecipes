package com.example.myrecipes.repository

import android.content.Context
import com.example.myrecipes.api.ApiService
import com.example.myrecipes.api.SpoonacularApi
import com.example.myrecipes.api.responsemodel.RecipeDTO
import com.example.myrecipes.model.Recipe

object RecipeRepository {

    suspend fun getRandomRecipes(): List<Recipe> {
        return SpoonacularApi.apiService.getRandomRecipes().body()?.recipes?.map {
            mapToRecipe(it)
        } ?: emptyList()
    }

    fun mapToRecipe(recipeDTO: RecipeDTO): Recipe {
        return Recipe(
            id = recipeDTO.id,
            title = recipeDTO.title,
            imageUrl = recipeDTO.imageUrl
        )
    }
}