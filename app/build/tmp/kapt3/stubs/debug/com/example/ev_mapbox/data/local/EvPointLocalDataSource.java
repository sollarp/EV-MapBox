package com.example.ev_mapbox.data.local;

import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/ev_mapbox/data/local/EvPointLocalDataSource;", "", "evPointsDao", "Lcom/example/ev_mapbox/data/local/EvPointsDao;", "(Lcom/example/ev_mapbox/data/local/EvPointsDao;)V", "fetchPoints", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "updatePoints", "", "app_debug"})
@javax.inject.Singleton()
public final class EvPointLocalDataSource {
    private final com.example.ev_mapbox.data.local.EvPointsDao evPointsDao = null;
    
    @javax.inject.Inject()
    public EvPointLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.data.local.EvPointsDao evPointsDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity>> fetchPoints() {
        return null;
    }
    
    public final void updatePoints(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity> evPointsDao) {
    }
}