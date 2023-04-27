package com.soldevcode.evmapbox.di

import com.soldevcode.evmapbox.domain.ISearchListUseCase
import com.soldevcode.evmapbox.domain.SearchListUseCaseImpl
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