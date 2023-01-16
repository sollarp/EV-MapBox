package com.example.call_mapbox_api.data

import com.example.call_mapbox_api.data.local.EvPointsDao
import com.example.call_mapbox_api.data.remote.EvPointsBrakeItem
import kotlinx.coroutines.flow.Flow

class EvPointLocalDataSource(private val evPointsDao: EvPointsDao) : IEvPointLocalDataSource {

    override suspend fun fetchPoints(): Flow<List<EvPointsBrakeItem>> {
        return evPointsDao.getEvPoints()
    }

    override suspend fun updatePoints(evPoints: List<EvPointsBrakeItem>) {
        this.evPointsDao.insert(evPoints)

    }
}

interface IEvPointLocalDataSource {

    suspend fun fetchPoints(): Flow<List<EvPointsBrakeItem>>

    suspend fun updatePoints(evPointsDao: List<EvPointsBrakeItem>)
}

