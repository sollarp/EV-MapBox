package com.example.call_mapbox_api.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.call_mapbox_api.data.remote.EvPointsEntity
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