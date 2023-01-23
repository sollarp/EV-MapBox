package com.example.call_mapbox_api.di

import com.example.call_mapbox_api.data.local.EvPointLocalDataSourceImpl
import com.example.call_mapbox_api.data.local.IEvPointLocalDataSource
import com.example.call_mapbox_api.data.IEvPointRemoteDataSource
import com.example.call_mapbox_api.data.remote.EvPointRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(impl: EvPointRemoteDataSourceImpl): IEvPointRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(impl: EvPointLocalDataSourceImpl): IEvPointLocalDataSource
}
