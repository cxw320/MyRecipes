package com.example.myrecipes.features.recipediscovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipes.domain.MyRecipesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * This is the ViewModel that will be used by the RecipeDiscoveryScreen
 */

@HiltViewModel //This annotation tells Hilt that this class should be injected
class RecipeDiscoveryViewModel @Inject constructor(
    private val myRecipesRepository: MyRecipesRepository //This is the repository that will be injected
) : ViewModel() {

    //-------Section 1: Ui Variables that expose state to your composables---------

    //Below is a variable you can update (private to this class)
    private val _recipeDiscoveryUiState = MutableStateFlow(RecipeDiscoveryUiState())

    //Below is an immutable version of this same variable that your composables have access to
    val recipeDiscoveryUiState: StateFlow<RecipeDiscoveryUiState> =
        _recipeDiscoveryUiState.asStateFlow()

    //-------Section 2: Methods that update state----------------------------------
    init {
        getRandomRecipes()
    }

    fun getRandomRecipes() {
        viewModelScope.launch {
            _recipeDiscoveryUiState.value =
                _recipeDiscoveryUiState.value.copy(
                    recipeList = myRecipesRepository.getRandomRecipes()
                )
        }
    }
}
