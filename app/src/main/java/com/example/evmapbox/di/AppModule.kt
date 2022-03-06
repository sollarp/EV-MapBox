package com.example.evmapbox.di

// From AppModule inject functions to activities, MainActivity, Room, Retrofit...


import com.example.evmapbox.data.EvRepoImpl
import com.example.evmapbox.data.remote.OpenMapApi
import com.example.evmapbox.domain.repository.EvMapRepo
import com.example.evmapbox.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("String1")
    fun provideTestString1() = "This is a string we will inject"

    @Provides
    @Singleton
    fun provideOpenMapApi(): OpenMapApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenMapApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOpenMapRepository(api: OpenMapApi): EvMapRepo {
        return EvRepoImpl(api)
    }

}