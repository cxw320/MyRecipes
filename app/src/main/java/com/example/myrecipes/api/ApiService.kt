package com.example.myrecipes.api

import com.example.myrecipes.api.interceptors.SpoonacularInterceptor
import com.example.myrecipes.api.responsemodel.RecipeListResponse
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface ApiService {

    @GET("random?number=20")
    suspend fun getRandomRecipes(): RecipeListResponse

}

//The below section will eventually be moved to our repository (its not common in android development to instantiate these services in the same file)

private const val BASE_URL = "https://api.spoonacular.com/recipes/"

//We use a client builder to modify our request to include an api key
val client: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(SpoonacularInterceptor())
    .build()

private val retrofit = Retrofit.Builder()
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

//Creating this so I can access this in the main activity for my "test" since object can be accessed globally without needing to instantiate
object SpoonacularApi {
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

