package com.example.myrecipes.domain

import com.example.myrecipes.model.Recipe

/**
 * This interface defines the methods that the repository will implement
 */

interface MyRecipesRepository {
    suspend fun getRandomRecipes() : List<Recipe>
}