package com.example.myrecipes.model

data class Recipe(
    val id: Long,
    val recipeName: String,
    val imageUrl: String?,
    val summary: String
)