package com.example.myrecipes.model

data class Recipe(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val summary: String
)