package com.example.myrecipes

import com.example.myrecipes.features.recipediscovery.RecipeDiscoveryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class RecipeDiscoveryViewModelTest {

    private var fakeMyRecipesRepository = FakeRepositoryImpl

    @Test
    fun `getRandomRecipes should update recipeDiscoveryUiState with random recipes`() = runTest {
        //Given
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)
        val recipeDiscoveryViewModel = RecipeDiscoveryViewModel(fakeMyRecipesRepository)

        // When
        recipeDiscoveryViewModel.getRandomRecipes()

        // Then
        val uiState = recipeDiscoveryViewModel.recipeDiscoveryUiState.value
        assertEquals(2, uiState.recipeList.size) // Check if there are 2 fake recipes
    }
}
