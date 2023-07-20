package com.example.myrecipes.domain.repository

import com.example.myrecipes.api.ApiService
import com.example.myrecipes.domain.MyRecipesRepository
import com.example.myrecipes.model.Recipe
import mapToRecipe
import javax.inject.Inject

/**
 * This class implements the MyRecipesRepository interface
 */

class MyRecipesRepositoryImpl @Inject constructor(
    private val apiService: ApiService //We need to inject the ApiService into this repository implementation
) : MyRecipesRepository{

    //This is the method that will be called from the ViewModel
    override suspend fun getRandomRecipes(): List<Recipe> {
        return apiService.getRandomRecipes().recipes.map { recipe ->
            recipe.mapToRecipe()
        }
    }
}