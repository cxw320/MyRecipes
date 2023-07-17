package com.example.myrecipes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyRecipesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}