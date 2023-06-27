package com.example.myrecipes.api.responsemodel

import com.example.myrecipes.model.Recipe
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class RecipeDTO(
    val id: Long,
    @Json(name = "title") val recipeName: String,
    val imageUrl: String?,
    val summary: String
)
fun RecipeDTO.mapToRecipe(): Recipe {
    return Recipe(
        id = this.id,
        recipeName = this.recipeName,
        imageUrl = this.imageUrl ?: "",
        summary = this.summary
    )
}
