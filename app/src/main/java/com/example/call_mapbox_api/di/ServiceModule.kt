package com.example.call_mapbox_api.di

import com.example.call_mapbox_api.data.OpenMapApi
import com.example.call_mapbox_api.data.RetrofitClient
import com.example.call_mapbox_api.model.EvPointDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {

    @Provides
    @Singleton
    suspend fun provideApiResult(openMapApi: OpenMapApi): List<EvPointDetails> {
        return openMapApi.getMaxResults()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): OpenMapApi = retrofit.create(OpenMapApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = RetrofitClient().retrofit

}