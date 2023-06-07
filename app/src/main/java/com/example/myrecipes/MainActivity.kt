package com.example.myrecipes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.myrecipes.api.SpoonacularApiService
import com.example.myrecipes.api.responsemodel.RecipeDTO
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.screens.recipediscovery.RecipeDiscoveryScreen
import com.example.myrecipes.ui.theme.MyRecipesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var spoonacularApi : SpoonacularApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TESTING the api to make sure we didn't mess up *fingers crossed* =D !!!!
        lifecycleScope.launch {
            val recipeList = spoonacularApi.getRandomRecipes().body()?.recipes?.map {
                mapToRecipeModel(it)
            } ?: listOf(Recipe())
            Log.d("Caroline","${recipeList[0]}")
        }
        setContent {
            MyRecipesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RecipeDiscoveryScreen()
                }
            }
        }
    }

    fun mapToRecipeModel(response: RecipeDTO): Recipe {
        return Recipe(
            id = response.id,
            title = response.title,
            imageUrl = response.imageUrl
        )
    }

}