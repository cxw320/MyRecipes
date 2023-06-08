package com.example.myrecipes.api.di

import com.example.myrecipes.api.SpoonacularApiService
import com.example.myrecipes.api.client
import com.example.myrecipes.api.interceptors.SpoonacularInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SpoonacularApiModule {

    @Provides
    @Singleton
    fun providesSpoonacularApi(builder: Retrofit.Builder) : SpoonacularApiService {
        return builder
            .build()
            .create(SpoonacularApiService::class.java)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/recipes/")
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(SpoonacularInterceptor())
            .build()
    }


}