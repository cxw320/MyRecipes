package com.example.myrecipes.screens.recipediscovery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class RecipeDiscoveryViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    val uiState = MutableStateFlow(RecipeDiscoveryUiState())

    init {
        viewModelScope.launch{
            val recipeList = recipeRepository.getRandomRecipes()
            Log.d("Caroline","recipe list is $recipeList")
            uiState.emit(
                uiState.value.copy(
                    recipeList = recipeList
                )
            )
        }
    }

}