package com.example.call_mapbox_api.data.local

import com.example.call_mapbox_api.data.remote.EvPointsEntity
import kotlinx.coroutines.flow.Flow

interface IEvPointLocalDataSource {

    suspend fun fetchPoints(): Flow<List<EvPointsEntity>>

    suspend fun updatePoints(evPointsDao: List<EvPointsEntity>)
}

