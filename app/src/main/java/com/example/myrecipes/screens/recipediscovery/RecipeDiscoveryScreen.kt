package com.example.myrecipes.screens.recipediscovery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myrecipes.model.Recipe

data class RecipeDiscoveryUiState(
    val recipeList: List<Recipe> = mutableListOf()
)
@Composable
fun RecipeDiscoveryScreen(
    viewModel: RecipeDiscoveryViewModel = hiltViewModel()
) {

    val recipeDiscoveryUiState by viewModel.uiState.collectAsState()

    Column {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(5.dp),
            columns = GridCells.Fixed(2)
        ) {
            items( recipeDiscoveryUiState.recipeList) { recipe ->
                RecipeCard(recipe = recipe)
            }
        }
    }
}


