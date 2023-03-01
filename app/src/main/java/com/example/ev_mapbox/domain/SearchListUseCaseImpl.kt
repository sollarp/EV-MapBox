package com.example.ev_mapbox.domain

import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.data.repository.ISearchListRepository
import com.example.ev_mapbox.domain.ISearchListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchListUseCaseImpl @Inject constructor(
    private val searchListRepository: ISearchListRepository,
    private val dispatcher: CoroutineDispatcher
) : ISearchListUseCase
{

    override suspend operator fun invoke(): Flow<List<EvPointsEntity>> {
       val ret =  withContext(dispatcher) {
            searchListRepository.fetchList()
        }
        println("nezz meg  $ret")
        return ret
    }

}
