package com.example.myrecipes.di

import com.example.myrecipes.api.ApiService
import com.example.myrecipes.api.interceptors.SpoonacularInterceptor
import com.example.myrecipes.domain.MyRecipesRepository
import com.example.myrecipes.domain.repository.MyRecipesRepositoryImpl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // ----- INSTANTIATING RETROFIT INSTANCE ------- //
    @Provides //Adds the following method to the DI graph
    fun provideRetrofitService(): ApiService {
        val BASE_URL = "https://api.spoonacular.com/recipes/"

        //We use a client builder to modify our request to include an api key
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(SpoonacularInterceptor())
            .build()

        return Retrofit.Builder()
            //we need to provide a base url
            .baseUrl(BASE_URL)
            // we need to tell Retrofit how to convert the format of the data it gets back
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().build()
                )
            )
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Named("myRecipeRepositoryImpl") //This is a named binding
    fun provideMyRecipeRepositoryImpl(recipeImpl: MyRecipesRepositoryImpl): MyRecipesRepository {
        return recipeImpl
    }
}
