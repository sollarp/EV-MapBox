package com.example.ev_mapbox.di;

import android.content.Context;
import androidx.room.Room;
import com.example.ev_mapbox.data.local.EvPointDataBase;
import com.example.ev_mapbox.data.local.EvPointsDao;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/ev_mapbox/di/DatabaseModule;", "", "()V", "provideDataBase", "Lcom/example/ev_mapbox/data/local/EvPointDataBase;", "appContext", "Landroid/content/Context;", "provideEvPointsDao", "Lcom/example/ev_mapbox/data/local/EvPointsDao;", "database", "providesDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "app_debug"})
@dagger.Module()
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.ev_mapbox.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.ev_mapbox.data.local.EvPointDataBase provideDataBase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context appContext) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final kotlinx.coroutines.CoroutineDispatcher providesDefaultDispatcher() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.ev_mapbox.data.local.EvPointsDao provideEvPointsDao(@org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.data.local.EvPointDataBase database) {
        return null;
    }
}