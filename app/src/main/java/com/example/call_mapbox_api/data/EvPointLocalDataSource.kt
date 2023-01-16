package com.example.call_mapbox_api.data

import com.example.call_mapbox_api.data.local.EvPointsEntity
import com.example.call_mapbox_api.data.local.EvPointsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EvPointLocalDataSource @Inject constructor(
    private val evPointsDao: EvPointsDao
) :
    IEvPointLocalDataSource {

    override suspend fun fetchPoints(): Flow<List<EvPointsEntity>> {
        return evPointsDao.getEvPoints()
    }

    override suspend fun updatePoints(evPoints: List<EvPointsEntity>) {
        this.evPointsDao.insert(evPoints)

    }
}

interface IEvPointLocalDataSource {

    suspend fun fetchPoints(): Flow<List<EvPointsEntity>>

    suspend fun updatePoints(evPointsDao: List<EvPointsEntity>)
}

