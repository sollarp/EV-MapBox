package com.example.call_mapbox_api.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.call_mapbox_api.data.remote.EvPointsBrakeItem
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface EvPointsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(evPointDetails: List<EvPointsBrakeItem>)

    @Query("SELECT * FROM evPointsDb")
    fun getEvPoints():  Flow<List<EvPointsBrakeItem>>

    @Query("DELETE FROM evPointsDb")
    suspend fun deleteAll()
}