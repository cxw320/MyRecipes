package com.example.myrecipes.repository

import com.example.myrecipes.api.ApiService
import com.example.myrecipes.api.interceptors.SpoonacularInterceptor
import com.example.myrecipes.api.responsemodel.RecipeDTO
import com.example.myrecipes.api.responsemodel.mapToRecipe
import com.example.myrecipes.model.Recipe
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RecipeRepository {

    // ----- INSTANTIATING RETROFIT INSTANCE ------- //

    private val BASE_URL = "https://api.spoonacular.com/recipes/"

    //We use a client builder to modify our request to include an api key
    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(SpoonacularInterceptor())
        .build()

    private val retrofitService = Retrofit.Builder()
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
        .create(ApiService::class.java)


    // ------- METHODS FOR OUR VIEW MODELS TO USE TO RETRIEVE DATA ------- //

    suspend fun getRandomRecipes(): List<Recipe> {
        return retrofitService.getRandomRecipes().recipes.map {
            it.mapToRecipe()
        }
    }

}