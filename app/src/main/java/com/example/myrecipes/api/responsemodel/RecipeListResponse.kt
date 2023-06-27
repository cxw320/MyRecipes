package com.example.myrecipes.api.responsemodel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
data class RecipeListResponse (
    val recipes: List<RecipeDTO>
)