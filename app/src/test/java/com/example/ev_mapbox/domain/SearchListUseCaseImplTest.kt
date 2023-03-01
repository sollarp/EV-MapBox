package com.example.call_mapbox_api.domain

import com.example.ev_mapbox.fakeData.fakeEvPointsEntity
import com.example.ev_mapbox.data.repository.ISearchListRepository
import com.example.ev_mapbox.domain.ISearchListUseCase
import com.example.ev_mapbox.domain.SearchListUseCaseImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchListUseCaseTestImpl {

    private lateinit var searchListUseCase: ISearchListUseCase

    @Mock
    private lateinit var searchListRepository: ISearchListRepository

    @Before
    fun setUp() {
        searchListUseCase = SearchListUseCaseImpl(searchListRepository, Dispatchers.Default)
    }

    @Test
    fun `Convert EvPointEntity to EvPointDetails and check one item`() = runBlocking {
        `when`(searchListRepository.fetchList()).thenReturn(flowOf(listOf(fakeEvPointsEntity())))
        val actual = searchListUseCase.invoke().toList()[0].map { it.NumberOfPoints }
        val expected = listOf(fakeEvPointsEntity().NumberOfPoints)
        assertEquals(expected, actual)
    }
}
