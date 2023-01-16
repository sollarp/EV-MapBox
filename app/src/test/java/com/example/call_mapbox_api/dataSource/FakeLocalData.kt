package com.example.call_mapbox_api.dataSource

import com.example.call_mapbox_api.data.IEvPointLocalDataSource
import com.example.call_mapbox_api.data.local.EvPointsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class FakeLocalData: IEvPointLocalDataSource {

    private val fakeList = mutableListOf<EvPointsEntity>()

    override suspend fun fetchPoints(): Flow<List<EvPointsEntity>> {
        return flow { emit(fakeList) }
    }

    override suspend fun updatePoints(evPointsDao: List<EvPointsEntity>) {
        return
    }
}