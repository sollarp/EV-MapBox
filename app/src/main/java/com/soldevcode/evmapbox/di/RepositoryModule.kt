package com.soldevcode.evmapbox.di

import com.soldevcode.evmapbox.data.repository.ISearchListRepository
import com.soldevcode.evmapbox.data.repository.SearchListRepositoryImpl
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