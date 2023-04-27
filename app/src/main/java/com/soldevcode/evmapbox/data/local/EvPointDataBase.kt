package com.soldevcode.evmapbox.data.local

import androidx.room.*

@Database(entities = [EvPointsEntity::class], version = 3, exportSchema = false)
@TypeConverters(
    ConnectionConverter::class,
    AddressConverter::class,
    ConnectionTypeConverter::class
)

abstract class EvPointDataBase : RoomDatabase() {

    abstract fun evPointsDao(): EvPointsDao
}