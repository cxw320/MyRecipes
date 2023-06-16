package com.example.myrecipes

import android.app.Application
import com.example.myrecipes.repository.RecipeRepository

class MyRecipeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RecipeRepository.initialize()
    }


}