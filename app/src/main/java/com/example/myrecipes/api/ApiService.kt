package com.example.myrecipes.api

import com.example.myrecipes.api.responsemodel.RecipeListResponse
import retrofit2.http.GET


interface ApiService {

    @GET("random?number=20")
    suspend fun getRandomRecipes(): RecipeListResponse

}
