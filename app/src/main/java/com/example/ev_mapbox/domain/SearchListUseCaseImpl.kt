package com.example.ev_mapbox.domain

import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.data.repository.ISearchListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchListUseCaseImpl @Inject constructor(
    private val searchListRepository: ISearchListRepository,
    private val dispatcher: CoroutineDispatcher
) : ISearchListUseCase {
    override suspend operator fun invoke(): Flow<List<EvPointsEntity>> {
        return withContext(dispatcher) {
            searchListRepository.fetchList()
        }
    }
}


