package com.example.ev_mapbox.di

import com.example.ev_mapbox.data.OpenMapApi
import com.example.ev_mapbox.data.RetrofitClient
import com.example.ev_mapbox.domain.model.EvPointDetails
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