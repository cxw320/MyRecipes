package com.example.myrecipes.repository

import com.example.myrecipes.api.SpoonacularApiService
import com.example.myrecipes.api.responsemodel.RecipeDTO
import com.example.myrecipes.model.Recipe
import javax.inject.Inject

class RecipeRepository @Inject constructor (
    private val spoonacularApi: SpoonacularApiService
) {
    suspend fun getRandomRecipes(): List<Recipe> {
        return spoonacularApi.getRandomRecipes().body()?.recipes?.map {
            mapToRecipeModel(it)
        } ?: listOf(Recipe())
    }
    fun mapToRecipeModel(response: RecipeDTO): Recipe {
        return Recipe(
            id = response.id,
            title = response.title,
            imageUrl = response.imageUrl
        )
    }
}