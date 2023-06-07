package com.example.myrecipes.screens.recipediscovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDiscoveryViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private var recipeList = emptyList<Recipe>()

    init {
        viewModelScope.launch{
            recipeList = recipeRepository.getRandomRecipes()
        }
    }

}