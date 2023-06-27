package com.example.myrecipes.features.recipediscovery

import com.example.myrecipes.model.Recipe

data class RecipeDiscoveryUiState(
    val recipeList : List<Recipe> = emptyList()
)