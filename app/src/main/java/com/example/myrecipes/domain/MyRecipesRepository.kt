package com.example.myrecipes.domain

import com.example.myrecipes.model.Recipe

interface MyRecipesRepository {
    suspend fun getRandomRecipes() : List<Recipe>
}