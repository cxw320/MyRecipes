package com.example.myrecipes.api.responsemodel

import RecipeDTO
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeListResponse(
    val recipes: List<RecipeDTO>
)