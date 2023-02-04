package com.example.call_mapbox_api.data.repository

import com.example.call_mapbox_api.data.local.EvPointsEntity
import kotlinx.coroutines.flow.Flow

interface ISearchListRepository {
    suspend fun fetchList(): Flow<List<EvPointsEntity>>
}

