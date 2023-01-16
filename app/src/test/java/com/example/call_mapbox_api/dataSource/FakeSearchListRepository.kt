package com.example.call_mapbox_api.dataSource

import com.example.call_mapbox_api.data.local.EvPointsEntity
import com.example.call_mapbox_api.data.repository.ISearchListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeSearchListRepository: ISearchListRepository {

    private val fakeList = mutableListOf<EvPointsEntity>()

    override suspend fun fetchList(): Flow<List<EvPointsEntity>> {
        return flow { emit(fakeList) }
    }
}