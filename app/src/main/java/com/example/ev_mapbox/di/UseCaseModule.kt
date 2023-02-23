package com.example.ev_mapbox.di

import com.example.ev_mapbox.domain.ISearchListUseCase
import com.example.ev_mapbox.domain.SearchListUseCaseImpl
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