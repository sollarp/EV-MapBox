package com.example.ev_mapbox.di

import com.example.ev_mapbox.data.repository.ISearchListRepository
import com.example.ev_mapbox.data.repository.SearchListRepositoryImpl
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