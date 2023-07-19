package com.example.myrecipes

import com.example.myrecipes.domain.MyRecipesRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MyRecipesRepositoryTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Inject
    lateinit var myRecipesRepository: MyRecipesRepository

    @Before
    fun setUp() {
        hiltRule.inject() // Inject the MyRecipesRepository

        // No need to instantiate the MyRecipesRepository, as Hilt does it for us
    }

    @Test
    fun `getRandomRecipes should return a list of fake recipes`() {
        coroutineTestRule.runBlockingTest {
            // When
            val recipes = myRecipesRepository.getRandomRecipes()

            // Then
            assertEquals(2, recipes.size) // Check if there are 2 fake recipes
            // You can also do more specific assertions for each recipe if needed.
        }
    }
}
