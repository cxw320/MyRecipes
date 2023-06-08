package com.example.myrecipes.api

import com.example.myrecipes.api.interceptors.SpoonacularInterceptor
import com.example.myrecipes.api.responsemodel.RecipeListResponse
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface SpoonacularApiService {

    @GET("random?number=20")
    suspend fun getRandomRecipes(): Response<RecipeListResponse>

}

val client: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(SpoonacularInterceptor())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl("https://api.spoonacular.com/recipes/")
    .client(client)
    .addConverterFactory(
        MoshiConverterFactory.create(
            Moshi.Builder().build()
        )
    )
    .build()