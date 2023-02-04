package com.example.call_mapbox_api.data.remote

import com.example.call_mapbox_api.data.OpenMapApi
import com.example.call_mapbox_api.fakeData.fakeEvPointDetails
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EvPointRemoteDataSourceTestImpl {

    private lateinit var evPointRemoteDataSource: EvPointRemoteDataSource

    @Mock
    lateinit var openMapApi: OpenMapApi

    @Before
    fun setUp() {
        evPointRemoteDataSource = EvPointRemoteDataSource(openMapApi)
    }

    @Test
    fun `verify EvPointRemoteDataSource getLatestEvPoint() return value`(): Unit = runBlocking {
        val evPointDetails = listOf(fakeEvPointDetails())
        val evPointRemoteDataSourceImpl = EvPointRemoteDataSource(openMapApi)

        `when`(openMapApi.getMaxResults()).thenReturn(evPointDetails)
        val result = evPointRemoteDataSourceImpl.getLatestEvPoint().toList().first()

        assertEquals(evPointDetails, result)
        verify(openMapApi).getMaxResults()
    }

}