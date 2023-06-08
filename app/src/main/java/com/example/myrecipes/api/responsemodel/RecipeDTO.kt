package com.example.myrecipes.api.responsemodel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter=true)
class RecipeDTO (
    @Json(name="id") val id : Long = -1,
    @Json(name="title") val title : String = "",
    @Json(name="image") val imageUrl : String = "",
    @Json(name="summary") val summary : String = ""
)