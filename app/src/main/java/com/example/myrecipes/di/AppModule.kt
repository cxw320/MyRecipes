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
import javax.inject.Singleton

/**
 * This class is responsible for providing dependencies to the DI graph
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // ----- INSTANTIATING RETROFIT INSTANCE ------- //

    @Provides //Adds the following method to the DI graph
    @Singleton //This tells Hilt that this method should only be called once
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
            //You also have the option of passing in an OkHttpClient instance during initialization to customize behavior
            //Customization includes: setting time-outs,enabling caching
            //The other advantage is defining interceptors which can modify requests or responses
            //In this case, we want to take advantage of an interceptor to add an api key to our request
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton //Redundant but good practice
    fun provideMyRecipeRepositoryImpl(recipeImpl: MyRecipesRepositoryImpl): MyRecipesRepository {
        return recipeImpl
    }
}
