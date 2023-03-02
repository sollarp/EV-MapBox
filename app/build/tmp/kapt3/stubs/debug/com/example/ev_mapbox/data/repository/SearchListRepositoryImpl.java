package com.example.ev_mapbox.data.repository;

import com.example.ev_mapbox.data.local.EvPointLocalDataSource;
import com.example.ev_mapbox.data.local.EvPointsEntity;
import com.example.ev_mapbox.data.remote.EvPointRemoteDataSource;
import com.example.ev_mapbox.domain.model.EvPointDetails;
import com.example.ev_mapbox.util.Resource;
import kotlinx.coroutines.flow.Flow;
import retrofit2.HttpException;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/ev_mapbox/data/repository/SearchListRepositoryImpl;", "Lcom/example/ev_mapbox/data/repository/ISearchListRepository;", "evPointDataSource", "Lcom/example/ev_mapbox/data/remote/EvPointRemoteDataSource;", "localDataSource", "Lcom/example/ev_mapbox/data/local/EvPointLocalDataSource;", "(Lcom/example/ev_mapbox/data/remote/EvPointRemoteDataSource;Lcom/example/ev_mapbox/data/local/EvPointLocalDataSource;)V", "fetchList", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@javax.inject.Singleton()
public final class SearchListRepositoryImpl implements com.example.ev_mapbox.data.repository.ISearchListRepository {
    private final com.example.ev_mapbox.data.remote.EvPointRemoteDataSource evPointDataSource = null;
    private final com.example.ev_mapbox.data.local.EvPointLocalDataSource localDataSource = null;
    
    @javax.inject.Inject()
    public SearchListRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.data.remote.EvPointRemoteDataSource evPointDataSource, @org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.data.local.EvPointLocalDataSource localDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object fetchList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity>>> continuation) {
        return null;
    }
}