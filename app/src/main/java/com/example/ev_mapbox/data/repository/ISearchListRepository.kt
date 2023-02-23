package com.example.ev_mapbox.data.repository

import com.example.ev_mapbox.data.local.EvPointsEntity
import kotlinx.coroutines.flow.Flow

interface ISearchListRepository {
    suspend fun fetchList(): Flow<List<EvPointsEntity>>
}

