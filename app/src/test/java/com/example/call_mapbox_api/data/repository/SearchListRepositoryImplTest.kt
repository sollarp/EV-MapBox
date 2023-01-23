package com.example.call_mapbox_api.data.repository

import com.example.call_mapbox_api.data.IEvPointRemoteDataSource
import com.example.call_mapbox_api.data.local.IEvPointLocalDataSource
import com.example.call_mapbox_api.fakeData.fakeEvPointsEntity
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchListRepositoryTestImpl {

    private lateinit var searchListRepository: ISearchListRepository

    @Mock
    lateinit var evPointRemoteDataSource: IEvPointRemoteDataSource

    @Mock
    lateinit var evPointLocalDataSource: IEvPointLocalDataSource

    @Before
    fun setUp() {
        searchListRepository = SearchListRepositoryImpl(evPointRemoteDataSource, evPointLocalDataSource)
    }

    @Test
    fun `Check local and remote data source objects`() = runBlocking {
        val actual = searchListRepository.fetchList()
        assertEquals(evPointRemoteDataSource.getLatestEvPoint(), actual)
        assertEquals(evPointLocalDataSource.fetchPoints(), actual)
    }

    @Test
    fun `Test localDataSource entities and verify one item`() = runBlocking {
        Mockito.`when`(evPointLocalDataSource.fetchPoints()).thenReturn(fakeEvPointsEntity())
        val actual = searchListRepository.fetchList().toList()[0]
            .toList()
            .map { it.NumberOfPoints }
        val expected = fakeEvPointsEntity().toList()[0].map { it.NumberOfPoints }
        assertEquals(expected, actual)
    }
}