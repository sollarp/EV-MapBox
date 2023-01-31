package com.example.call_mapbox_api.domain

import com.example.call_mapbox_api.data.remote.EvPointsEntity
import com.example.call_mapbox_api.data.repository.ISearchListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchListUseCaseImpl @Inject constructor(
    private val searchListRepository: ISearchListRepository,
    private val dispatcher: CoroutineDispatcher
) : ISearchListUseCase
{

    override suspend operator fun invoke(): Flow<List<EvPointsEntity>> =
        withContext(dispatcher) {
            searchListRepository.fetchList()
        }
}
