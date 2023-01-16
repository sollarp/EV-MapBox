package com.example.call_mapbox_api.domain

import com.example.call_mapbox_api.data.repository.ISearchListRepository
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.data.remote.toEvPointDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class SearchListUseCase (
    private val searchListRepository: ISearchListRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default) : ISearchListUseCase
{

    override suspend operator fun invoke(): Flow<List<EvPointDetails>> =
        withContext(dispatcher) {
            searchListRepository.fetchList().map { items -> items.toEvPointDetails() }
            }
    }

interface ISearchListUseCase {
    suspend operator fun invoke(): Flow<List<EvPointDetails>>
}
