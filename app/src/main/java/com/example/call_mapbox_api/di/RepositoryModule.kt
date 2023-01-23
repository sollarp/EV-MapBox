package com.example.call_mapbox_api.di

import com.example.call_mapbox_api.data.repository.ISearchListRepository
import com.example.call_mapbox_api.data.repository.SearchListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSearchListRepository(impl: SearchListRepositoryImpl): ISearchListRepository
}