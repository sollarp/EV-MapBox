package com.example.call_mapbox_api.domain

import com.example.call_mapbox_api.data.remote.EvPointsEntity
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.flow.Flow

interface ISearchListUseCase {
    suspend operator fun invoke(): Flow<List<EvPointsEntity>>
}
