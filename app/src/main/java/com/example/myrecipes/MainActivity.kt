package com.example.myrecipes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.myrecipes.api.SpoonacularApiService
import com.example.myrecipes.api.responsemodel.RecipeDTO
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.screens.recipediscovery.RecipeDiscoveryScreen
import com.example.myrecipes.ui.theme.MyRecipesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyRecipesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // RecipeDiscoveryScreen()
                }
            }
        }
    }

}