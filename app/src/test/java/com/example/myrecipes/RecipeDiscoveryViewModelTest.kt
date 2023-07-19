package com.example.myrecipes

import com.example.myrecipes.domain.repository.FakeRepositoryImpl
import com.example.myrecipes.features.recipediscovery.RecipeDiscoveryViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class RecipeDiscoveryViewModelTest {

    private var fakeMyRecipesRepository = FakeRepositoryImpl

    // The ViewModel to be tested
    private lateinit var recipeDiscoveryViewModel: RecipeDiscoveryViewModel

    @Before
    fun setUp() {

        // Instantiate the ViewModel with the fake repository
        recipeDiscoveryViewModel = RecipeDiscoveryViewModel(fakeMyRecipesRepository)
    }

    @Test
    fun `getRandomRecipes should update recipeDiscoveryUiState with random recipes`() {
        //        coroutineTestRule.runBlockingTest {
        // When
        recipeDiscoveryViewModel.getRandomRecipes()

        // Then
        val uiState = recipeDiscoveryViewModel.recipeDiscoveryUiState.value
        assertEquals(2, uiState.recipeList.size) // Check if there are 2 fake recipes
        // You can also do more specific assertions for each recipe if needed.
    }
}

