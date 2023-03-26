package com.example.ev_mapbox.domain;

import com.example.ev_mapbox.data.local.EvPointsEntity;
import com.example.ev_mapbox.data.repository.ISearchListRepository;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/ev_mapbox/domain/SearchListUseCaseImpl;", "Lcom/example/ev_mapbox/domain/ISearchListUseCase;", "searchListRepository", "Lcom/example/ev_mapbox/data/repository/ISearchListRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/example/ev_mapbox/data/repository/ISearchListRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SearchListUseCaseImpl implements com.example.ev_mapbox.domain.ISearchListUseCase {
    private final com.example.ev_mapbox.data.repository.ISearchListRepository searchListRepository = null;
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    
    @javax.inject.Inject()
    public SearchListUseCaseImpl(@org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.data.repository.ISearchListRepository searchListRepository, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity>>> continuation) {
        return null;
    }
}