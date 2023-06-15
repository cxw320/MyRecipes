package com.example.myrecipes.repository

import com.example.myrecipes.api.ApiService
import com.example.myrecipes.api.responsemodel.RecipeDTO
import com.example.myrecipes.model.Recipe

class RecipeRepository(
    //Add in dependencies this class needs for its constructor.
    private val apiService: ApiService
) {

    suspend fun getRandomRecipes() : List<Recipe> {
        return apiService.getRandomRecipes().body()?.recipes?.map {
            mapToRecipe(it)
        } ?: emptyList()
    }

    fun mapToRecipe(recipeDTO: RecipeDTO) : Recipe {
        return Recipe(
            id = recipeDTO.id,
            title = recipeDTO.title,
            imageUrl = recipeDTO.imageUrl
        )
    }
}