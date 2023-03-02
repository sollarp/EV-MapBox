package com.example.ev_mapbox.di;

import com.example.ev_mapbox.domain.ISearchListUseCase;
import com.example.ev_mapbox.domain.SearchListUseCaseImpl;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/example/ev_mapbox/di/UseCaseModule;", "", "()V", "bindSearchListUseCase", "Lcom/example/ev_mapbox/domain/ISearchListUseCase;", "impl", "Lcom/example/ev_mapbox/domain/SearchListUseCaseImpl;", "app_debug"})
@dagger.Module()
public abstract class UseCaseModule {
    
    public UseCaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    @javax.inject.Singleton()
    public abstract com.example.ev_mapbox.domain.ISearchListUseCase bindSearchListUseCase(@org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.domain.SearchListUseCaseImpl impl);
}