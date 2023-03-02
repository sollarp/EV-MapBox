package com.example.ev_mapbox.data.local;

import androidx.room.*;

@androidx.room.TypeConverters(value = {com.example.ev_mapbox.data.local.ConnectionConverter.class, com.example.ev_mapbox.data.local.AddressConverter.class, com.example.ev_mapbox.data.local.ConnectionTypeConverter.class})
@androidx.room.Database(entities = {com.example.ev_mapbox.data.local.EvPointsEntity.class}, version = 3, exportSchema = false)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/ev_mapbox/data/local/EvPointDataBase;", "Landroidx/room/RoomDatabase;", "()V", "evPointsDao", "Lcom/example/ev_mapbox/data/local/EvPointsDao;", "app_debug"})
public abstract class EvPointDataBase extends androidx.room.RoomDatabase {
    
    public EvPointDataBase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.ev_mapbox.data.local.EvPointsDao evPointsDao();
}