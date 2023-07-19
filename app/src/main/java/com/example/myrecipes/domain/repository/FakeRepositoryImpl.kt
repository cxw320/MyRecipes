package com.example.myrecipes.domain.repository

import com.example.myrecipes.domain.MyRecipesRepository
import com.example.myrecipes.model.Recipe
import kotlinx.coroutines.delay


object FakeRepositoryImpl : MyRecipesRepository {

    override suspend fun getRandomRecipes(): List<Recipe> {

        // Generate fake recipes for testing
        val recipe1 = Recipe(
            id = 1,
            recipeName = "Spaghetti Bolognese",
            imageUrl = "https://example.com/spaghetti_bolognese.jpg",
            summary = "Delicious spaghetti with meat sauce"
        )

        val recipe2 = Recipe(
            id = 2,
            recipeName = "Chocolate Cake",
            imageUrl = "https://example.com/chocolate_cake.jpg",
            summary = "Decadent chocolate cake with frosting"
        )

        return listOf(recipe1, recipe2)
    }
}
