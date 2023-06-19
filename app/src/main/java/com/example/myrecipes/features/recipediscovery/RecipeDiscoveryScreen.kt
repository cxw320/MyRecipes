package com.example.myrecipes.features.recipediscovery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myrecipes.model.Recipe



data class recipeDiscoveryUiState(
    val recipeList : List<Recipe> = emptyList()
)


@Composable
fun RecipeDiscoveryScreen(
    //viewmodel is initialized here via compose viewmodel dependency (implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    viewModel: RecipeDiscoveryViewModel = viewModel()
) {

    val recipeDiscoveryUiState = viewModel.recipeDiscoveryUiState.collectAsState()

    Column {
      Button(onClick = { viewModel.getRandomRecipes() }) {
          Text("Refresh")
      }
        LazyVerticalGrid(
            modifier = Modifier
                .padding(5.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(recipeDiscoveryUiState.value.recipeList) { recipe ->
                RecipeCard(recipe = recipe)
            }
        }
    }
}
