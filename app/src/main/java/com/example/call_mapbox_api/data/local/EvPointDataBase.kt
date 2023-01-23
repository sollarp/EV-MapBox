package com.example.call_mapbox_api.data.local

import androidx.room.*
import com.example.call_mapbox_api.data.remote.EvPointsEntity


@Database(entities = [EvPointsEntity::class], version = 2, exportSchema = false)
@TypeConverters(ConnectionConverter::class, AddressConverter::class)

abstract class EvPointDataBase : RoomDatabase() {

    abstract fun evPointsDao(): EvPointsDao
}