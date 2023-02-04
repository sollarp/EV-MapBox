package com.example.call_mapbox_api.domain

import com.example.call_mapbox_api.data.local.EvPointsEntity
import kotlinx.coroutines.flow.Flow

interface ISearchListUseCase {
    suspend operator fun invoke(): Flow<List<EvPointsEntity>>
}
