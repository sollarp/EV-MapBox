package com.example.call_mapbox_api.di

import com.example.call_mapbox_api.domain.ISearchListUseCase
import com.example.call_mapbox_api.domain.SearchListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun bindSearchListUseCase(impl: SearchListUseCaseImpl): ISearchListUseCase
}