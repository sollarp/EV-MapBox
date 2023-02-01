package com.example.call_mapbox_api.data.repository

import com.example.call_mapbox_api.data.local.EvPointLocalDataSource
import com.example.call_mapbox_api.data.remote.EvPointRemoteDataSource
import com.example.call_mapbox_api.fakeData.fakeEvPointDetails
import com.example.call_mapbox_api.fakeData.fakeEvPointsEntity
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchListRepositoryTestImpl {

    private lateinit var searchListRepository: ISearchListRepository

    @Mock
    lateinit var evPointRemoteDataSource: EvPointRemoteDataSource

    @Mock
    lateinit var evPointLocalDataSource: EvPointLocalDataSource

    @Before
    fun setUp() {
        searchListRepository = SearchListRepositoryImpl(evPointRemoteDataSource, evPointLocalDataSource)
    }

    @Test
    fun `return data from localDataSource after updating it with data from evPointDataSource`() =
        runBlocking {
            val evPointsEntity = listOf(fakeEvPointsEntity())
            val evPointsBreakItems = listOf(fakeEvPointDetails())
            `when`(evPointLocalDataSource.fetchPoints()).thenReturn(flowOf(evPointsEntity))
            `when`(evPointRemoteDataSource.getLatestEvPoint()).thenReturn(flowOf(evPointsBreakItems))

            val result = searchListRepository.fetchList().first()

            assertEquals(evPointsEntity, result)
            verify(evPointLocalDataSource, times(1)).fetchPoints()
            verify(evPointRemoteDataSource, times(1)).getLatestEvPoint()
            verify(evPointLocalDataSource, times(1)).updatePoints(evPointsEntity)
        }
}