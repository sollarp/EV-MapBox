package com.example.ev_mapbox.domain

import com.example.ev_mapbox.data.local.EvPointsEntity
import kotlinx.coroutines.flow.Flow

interface ISearchListUseCase {
    suspend operator fun invoke(): Flow<List<EvPointsEntity>>
}
