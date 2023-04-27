package com.soldevcode.evmapbox.domain

import com.soldevcode.evmapbox.data.local.EvPointsEntity
import kotlinx.coroutines.flow.Flow

interface ISearchListUseCase {
    suspend operator fun invoke(): Flow<List<EvPointsEntity>>
}
