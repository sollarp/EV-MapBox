package com.example.ev_mapbox.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface EvPointsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(evPointDetails: List<EvPointsEntity>)

    @Query("SELECT * FROM evPointsDb")
    fun getEvPoints():  Flow<List<EvPointsEntity>>

    @Query("DELETE FROM evPointsDb")
    suspend fun deleteAll()
}