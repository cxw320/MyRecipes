package com.example.myrecipes.features.recipediscovery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myrecipes.model.Recipe

data class RecipeDiscoveryUiState(
    val recipeList: List<Recipe> = emptyList()
)

@Composable
fun RecipeDiscoveryScreen(
    viewModel: RecipeDiscoveryViewModel = viewModel()
) {

    //"collectAsState" collects the latest value from Flow and convert it to Compose state (in a lifecycle aware way)
    //Link: https://medium.com/androiddevelopers/consuming-flows-safely-in-jetpack-compose-cde014d0d5a3
    val recipeDiscoveryUiState = viewModel.recipeDiscoveryUiState.collectAsStateWithLifecycle()

    Column {

        //Adding this button to demonstrate how to reference a method from viewModel
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
