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
import com.example.myrecipes.api.SpoonacularApi
import com.example.myrecipes.api.responsemodel.RecipeDTO
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.features.recipediscovery.RecipeDiscoveryScreen
import com.example.myrecipes.ui.theme.MyRecipesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Let's test that we can Log some data from the spoonacular api!
        //If we did everything correctly, we should see the first item in the recipe list printed in our Logcat
        lifecycleScope.launch{
            val recipeList = SpoonacularApi.apiService.getRandomRecipes().recipes.map {
                mapToRecipeModel(it)
            }
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
            imageUrl = response.imageUrl,
            summary = response.summary
        )
    }
}