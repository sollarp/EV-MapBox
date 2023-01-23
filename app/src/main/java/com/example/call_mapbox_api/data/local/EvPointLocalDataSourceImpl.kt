package com.example.call_mapbox_api.data.local

import com.example.call_mapbox_api.data.local.EvPointsDao
import com.example.call_mapbox_api.data.remote.EvPointsEntity
import com.example.call_mapbox_api.data.local.IEvPointLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EvPointLocalDataSourceImpl @Inject constructor(
    private val evPointsDao: EvPointsDao
) :
    IEvPointLocalDataSource {

    override suspend fun fetchPoints(): Flow<List<EvPointsEntity>> {
        return evPointsDao.getEvPoints()
    }

    override suspend fun updatePoints(evPointsDao: List<EvPointsEntity>) {
        this.evPointsDao.insert(evPointsDao)

    }
}