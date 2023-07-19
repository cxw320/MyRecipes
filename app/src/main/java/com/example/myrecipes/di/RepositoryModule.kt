package com.example.myrecipes.di

import com.example.myrecipes.domain.MyRecipesRepository
import com.example.myrecipes.domain.repository.MyRecipesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Dependencies live as long as the application.
abstract class RepositoryModule {

    @Binds
    @Singleton //Creates a single instance of this repository
    abstract fun bindMyRecipeRepository(
        recipeImpl: MyRecipesRepositoryImpl
    ): MyRecipesRepository
}