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

@HiltViewModel //This annotation tells Hilt that this class should be injected
class RecipeDiscoveryViewModel @Inject constructor(
    private val myRecipesRepositoryImpl: MyRecipesRepository
) : ViewModel() {

    //Below is a variable you can update (private to this class)
    private val _recipeDiscoveryUiState = MutableStateFlow(RecipeDiscoveryUiState())

    //Below is an immutable version of this same variable that your composables have access to
    val recipeDiscoveryUiState: StateFlow<RecipeDiscoveryUiState> =
        _recipeDiscoveryUiState.asStateFlow()

    init {
        getRandomRecipes()
    }

    fun getRandomRecipes() {
        viewModelScope.launch {
            _recipeDiscoveryUiState.value =
                _recipeDiscoveryUiState.value.copy(
                    recipeList = myRecipesRepositoryImpl.getRandomRecipes()
                )
        }
    }
}

//    private val myRecipesRepositoryImpl: MyRecipesRepositoryImpl = MyRecipesRepositoryImpl() //Instantiate your recipe repository dependency