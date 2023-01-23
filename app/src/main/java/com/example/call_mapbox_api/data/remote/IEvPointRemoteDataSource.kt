package com.example.call_mapbox_api.data

import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.flow.Flow

interface IEvPointRemoteDataSource {
    suspend fun getLatestEvPoint(): Flow<List<EvPointDetails>>
}

