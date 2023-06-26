package com.example.myrecipes.api.responsemodel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class RecipeDTO(
    val id: Long,
    @Json(name = "title") val recipeName: String,
    val imageUrl: String?,
    val summary: String
)
