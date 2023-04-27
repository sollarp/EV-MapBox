package com.soldevcode.evmapbox.di

import com.soldevcode.evmapbox.data.OpenMapApi
import com.soldevcode.evmapbox.data.RetrofitClient
import com.soldevcode.evmapbox.domain.model.EvPointDetails
import com.soldevcode.evmapbox.util.LocationProvider
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
        return openMapApi.getMaxResults(LocationProvider.longitude, LocationProvider.latitude)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): OpenMapApi = retrofit.create(OpenMapApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = RetrofitClient().retrofit


}