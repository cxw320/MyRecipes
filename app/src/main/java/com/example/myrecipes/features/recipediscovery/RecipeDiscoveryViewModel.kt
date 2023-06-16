package com.example.myrecipes.features.recipediscovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipes.api.ApiService
import com.example.myrecipes.api.SpoonacularApi
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.repository.RecipeRepository
import kotlinx.coroutines.launch

//this class extends the ViewModel class provided by Android Architecture Components
class RecipeDiscoveryViewModel : ViewModel() {

    //get access to your recipe repository
    val recipeRepository = RecipeRepository.get()

    //store the results of your repository (api call) into this local variable
    //this local variable is not in its final state - but let's hold this data here for now
    //the idea is that this variable will be accessed by  our composables - but we'll talk about how in the next step
    var recipeList = emptyList<Recipe>()

    init {
        viewModelScope.launch{
            recipeList = recipeRepository.getRandomRecipes()
        }


    }



}