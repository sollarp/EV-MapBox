package com.example.ev_mapbox.data.local;

import androidx.room.TypeConverter;
import com.example.ev_mapbox.data.remote.dto.AddressInfo;
import com.example.ev_mapbox.data.remote.dto.ConnectionType;
import com.example.ev_mapbox.data.remote.dto.Connections;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/ev_mapbox/data/local/AddressConverter;", "", "()V", "fromArrayList", "", "list", "Lcom/example/ev_mapbox/data/remote/dto/AddressInfo;", "fromString", "value", "app_debug"})
public final class AddressConverter {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.ev_mapbox.data.local.AddressConverter INSTANCE = null;
    
    private AddressConverter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final com.example.ev_mapbox.data.remote.dto.AddressInfo fromString(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.lang.String fromArrayList(@org.jetbrains.annotations.Nullable()
    com.example.ev_mapbox.data.remote.dto.AddressInfo list) {
        return null;
    }
}