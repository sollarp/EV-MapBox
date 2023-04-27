package com.soldevcode.evmapbox.data.repository

import com.soldevcode.evmapbox.data.local.EvPointsEntity
import kotlinx.coroutines.flow.Flow

interface ISearchListRepository {
    suspend fun fetchList(): Flow<List<EvPointsEntity>>
}

