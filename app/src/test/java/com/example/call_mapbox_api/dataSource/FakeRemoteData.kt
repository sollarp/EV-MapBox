package com.example.call_mapbox_api.dataSource

import com.example.call_mapbox_api.data.IEvPointRemoteDataSource
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRemoteData: IEvPointRemoteDataSource {

    private val fakeList = mutableListOf<EvPointDetails>()

    override suspend fun getLatestEvPoint(): Flow<List<EvPointDetails>> {
        return flow { emit(fakeList) }
    }
}