package com.example.myrecipes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Hilts needs an application class to be annotated with @HiltAndroidApp
 * because it will generate a base class for your application to let Hilt set up the dependency graph.
 */
@HiltAndroidApp
class MyRecipesApplication : Application()
