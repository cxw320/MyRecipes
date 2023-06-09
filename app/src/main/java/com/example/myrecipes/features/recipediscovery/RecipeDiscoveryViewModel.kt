package com.example.myrecipes.features.recipediscovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipes.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeDiscoveryViewModel : ViewModel() {

    //Instantiate your recipe repository dependency
    private val recipeRepository = RecipeRepository()

    //-------Section 1: Ui Variables that expose state to your composables---------

    //Below is a variable you can update (private to this class)
    private val _recipeDiscoveryUiState = MutableStateFlow(recipeDiscoveryUiState())

    //Below is an immutable version of this same variable that your composables have access to
    val recipeDiscoveryUiState : StateFlow<recipeDiscoveryUiState> = _recipeDiscoveryUiState.asStateFlow()


    //-------Section 2: Methods that update state----------------------------------

    init {
        getRandomRecipes()
    }

    fun getRandomRecipes() {
        viewModelScope.launch{
            _recipeDiscoveryUiState.value =
                _recipeDiscoveryUiState.value.copy(
                    recipeList = recipeRepository.getRandomRecipes()
                )
        }
    }

}