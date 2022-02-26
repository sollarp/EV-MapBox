package com.example.evmapbox.di

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
import javax.inject.Singleton

class AppModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {

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
}