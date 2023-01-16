package com.example.call_mapbox_api.data.repository

import com.example.call_mapbox_api.data.IEvPointLocalDataSource
import com.example.call_mapbox_api.data.IEvPointRemoteDataSource
import com.example.call_mapbox_api.dataSource.FakeLocalData
import com.example.call_mapbox_api.dataSource.FakeRemoteData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SearchListRepositoryTest {

    private lateinit var searchListRepository: SearchListRepository
    private lateinit var fakeLocalData : IEvPointLocalDataSource
    private lateinit var fakeRemoteData: IEvPointRemoteDataSource

    @Before
    fun setUp(){
        fakeRemoteData = FakeRemoteData()
        fakeLocalData = FakeLocalData()
        searchListRepository = SearchListRepository(fakeRemoteData, fakeLocalData)

    }

    @Test
    fun `Check local and remote database first item from Flow`() {

        runBlocking {
            val firstItem = searchListRepository.fetchList().first()
            assertEquals(fakeRemoteData.getLatestEvPoint().first(), firstItem )
            assertEquals(fakeLocalData.fetchPoints().first(), firstItem )
        }
    }
}
