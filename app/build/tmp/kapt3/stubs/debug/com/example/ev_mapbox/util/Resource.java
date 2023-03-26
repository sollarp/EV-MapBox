package com.example.ev_mapbox.util;

import com.example.ev_mapbox.domain.model.EvPointDetails;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\r\u000e\u000fB\u001f\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/example/ev_mapbox/util/Resource;", "T", "", "data", "message", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "isDataAvailable", "", "Error", "Loading", "Success", "Lcom/example/ev_mapbox/util/Resource$Error;", "Lcom/example/ev_mapbox/util/Resource$Loading;", "Lcom/example/ev_mapbox/util/Resource$Success;", "app_debug"})
public abstract class Resource<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object data = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String message = null;
    
    private Resource(java.lang.Object data, java.lang.String message) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final boolean isDataAvailable() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/ev_mapbox/util/Resource$Success;", "T", "Lcom/example/ev_mapbox/util/Resource;", "data", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/ev_mapbox/domain/model/EvPointDetails;", "(Lkotlinx/coroutines/flow/Flow;)V", "app_debug"})
    public static final class Success<T extends java.lang.Object> extends com.example.ev_mapbox.util.Resource<T> {
        
        public Success(@org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.ev_mapbox.domain.model.EvPointDetails>> data) {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/ev_mapbox/util/Resource$Error;", "T", "", "Lcom/example/ev_mapbox/util/Resource;", "message", "", "data", "(Ljava/lang/String;Ljava/lang/Object;)V", "app_debug"})
    public static final class Error<T extends java.lang.Object> extends com.example.ev_mapbox.util.Resource<T> {
        
        public Error(@org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.Nullable()
        T data) {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/example/ev_mapbox/util/Resource$Loading;", "T", "", "Lcom/example/ev_mapbox/util/Resource;", "data", "(Ljava/lang/Object;)V", "app_debug"})
    public static final class Loading<T extends java.lang.Object> extends com.example.ev_mapbox.util.Resource<T> {
        
        public Loading() {
            super(null, null);
        }
        
        public Loading(@org.jetbrains.annotations.Nullable()
        T data) {
            super(null, null);
        }
    }
}