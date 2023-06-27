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
import com.example.myrecipes.api.ApiService
import com.example.myrecipes.api.interceptors.SpoonacularInterceptor
import com.example.myrecipes.api.responsemodel.RecipeDTO
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.features.recipediscovery.RecipeDiscoveryScreen
import com.example.myrecipes.ui.theme.MyRecipesTheme
import com.squareup.moshi.Moshi
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //The below section creates our Retrofit instance and will need to eventually be moved out of main activity
        //This section will eventually be moved into a repository (but in future branches, we will also discuss hiding this instantiation code into a dependency injection library

        val BASE_URL = "https://api.spoonacular.com/recipes/"

        //We use a client builder to modify our request to include an api key
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(SpoonacularInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            //we need to provide a base url
            .baseUrl(BASE_URL)
            // we need to tell Retrofit how to convert the format of the data it gets back
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().build()
                )
            )
            //You also have the option of passing in an OkHttpClient instance during initialization to customize behavior
            //Customization includes: setting time-outs,enabling caching
            //The other advantage is defining interceptors which can modify requests or responses
            //In this case, we want to take advantage of an interceptor to add an api key to our request
            .client(client)
            .build()


        //Let's test that we can Log some data from the spoonacular api!
        //If we did everything correctly, we should see the first item in the recipe list printed in our Logcat
        lifecycleScope.launch{
            val recipeList = retrofit
                .create(ApiService::class.java)
                .getRandomRecipes()
                .recipes
                .map {
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
            recipeName = response.recipeName,
            imageUrl = response.imageUrl?:"",
            summary = response.summary
        )
    }
}