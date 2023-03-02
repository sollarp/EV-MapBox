package com.example.ev_mapbox.di;

import com.example.ev_mapbox.data.OpenMapApi;
import com.example.ev_mapbox.data.RetrofitClient;
import com.example.ev_mapbox.domain.model.EvPointDetails;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/ev_mapbox/di/ServiceModule;", "", "()V", "provideApiResult", "", "Lcom/example/ev_mapbox/domain/model/EvPointDetails;", "openMapApi", "Lcom/example/ev_mapbox/data/OpenMapApi;", "(Lcom/example/ev_mapbox/data/OpenMapApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provideApiService", "retrofit", "Lretrofit2/Retrofit;", "provideRetrofit", "app_debug"})
@dagger.Module()
public final class ServiceModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.ev_mapbox.di.ServiceModule INSTANCE = null;
    
    private ServiceModule() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final java.lang.Object provideApiResult(@org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.data.OpenMapApi openMapApi, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.ev_mapbox.domain.model.EvPointDetails>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.ev_mapbox.data.OpenMapApi provideApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRetrofit() {
        return null;
    }
}