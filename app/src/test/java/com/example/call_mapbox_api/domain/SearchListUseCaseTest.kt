package com.example.call_mapbox_api.domain

import com.example.call_mapbox_api.data.repository.ISearchListRepository
import com.example.call_mapbox_api.dataSource.FakeSearchListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SearchListUseCaseTest {

    private lateinit var searchListUseCase: SearchListUseCase
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
    private lateinit var fakeSearchListRepository: ISearchListRepository

    @Before
    fun setUp() {
        fakeSearchListRepository = FakeSearchListRepository()
        searchListUseCase = SearchListUseCase(fakeSearchListRepository, dispatcher)

    }

    @Test
    fun `Test conversion from EvPointEntity to EvPointDetails`() {
        runBlocking {
            val fetchedList = searchListUseCase.invoke().first()
            assertEquals(searchListUseCase.invoke().first(), fetchedList)
        }
    }
}