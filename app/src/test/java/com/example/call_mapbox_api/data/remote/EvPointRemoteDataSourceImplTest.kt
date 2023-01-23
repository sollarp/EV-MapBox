package com.example.call_mapbox_api.data.remote

import com.example.call_mapbox_api.data.IEvPointRemoteDataSource
import com.example.call_mapbox_api.data.OpenMapApi
import com.example.call_mapbox_api.fakeData.fakeEvPointDetails
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
class EvPointRemoteDataSourceTestImpl {

    private lateinit var evPointRemoteDataSource: IEvPointRemoteDataSource

    @Mock
    lateinit var openMapApi: OpenMapApi

    @Before
    fun setUp() {
        evPointRemoteDataSource = EvPointRemoteDataSourceImpl(openMapApi)
    }

    @Test
    fun `Test one item in EvPointDetails from OpenMapApi result`() = runBlocking {
        Mockito.`when`(openMapApi.getMaxResults()).thenReturn(fakeEvPointDetails())
        val actual = evPointRemoteDataSource.getLatestEvPoint().toList()[0]
            .map { it.NumberOfPoints }
        val expected = fakeEvPointDetails().map { it.NumberOfPoints }
        assertEquals(expected, actual)
    }
}