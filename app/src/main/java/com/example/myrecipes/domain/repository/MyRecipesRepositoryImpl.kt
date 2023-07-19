package com.example.myrecipes.domain.repository

import com.example.myrecipes.api.ApiService
import com.example.myrecipes.domain.MyRecipesRepository
import com.example.myrecipes.model.Recipe
import mapToRecipe
import javax.inject.Inject

class MyRecipesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MyRecipesRepository{

    override suspend fun getRandomRecipes(): List<Recipe> {
        return apiService.getRandomRecipes().recipes.map { recipe ->
            recipe.mapToRecipe()
        }
    }
}