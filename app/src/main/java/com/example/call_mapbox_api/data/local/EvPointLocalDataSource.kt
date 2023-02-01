package com.example.call_mapbox_api.data.local

import com.example.call_mapbox_api.data.remote.EvPointsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EvPointLocalDataSource @Inject constructor(
    private val evPointsDao: EvPointsDao) {

    suspend fun fetchPoints(): Flow<List<EvPointsEntity>> {
        return evPointsDao.getEvPoints()
    }

    suspend fun updatePoints(evPointsDao: List<EvPointsEntity>) {
        this.evPointsDao.insert(evPointsDao)

    }
}
