package com.example.ev_mapbox.data.local

import androidx.room.*

@Database(entities = [EvPointsEntity::class], version = 1, exportSchema = false)
@TypeConverters(ConnectionConverter::class, AddressConverter::class)

abstract class EvPointDataBase : RoomDatabase() {

    abstract fun evPointsDao(): EvPointsDao
}