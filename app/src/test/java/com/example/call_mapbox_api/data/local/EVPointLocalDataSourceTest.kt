package com.example.call_mapbox_api.data.local

import com.example.call_mapbox_api.fakeData.fakeEvPointsEntity
import kotlinx.coroutines.flow.flowOf
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
class EVPointLocalDataSourceTest {

    private lateinit var evPointLocalDataSource: EvPointLocalDataSource

    @Mock
    lateinit var evPointsDao: EvPointsDao

    @Before
    fun setUp() {
        evPointLocalDataSource = EvPointLocalDataSource(evPointsDao)
    }

    @Test
    fun fetchPoints_returnsData(): Unit = runBlocking {
        // Arrange
        val evPointsEntities = listOf(fakeEvPointsEntity())
        `when`(evPointsDao.getEvPoints()).thenReturn(flowOf(evPointsEntities))
        val evPointLocalDataSourceImpl = EvPointLocalDataSource(evPointsDao)

        // Act
        val result = evPointLocalDataSourceImpl.fetchPoints().toList().first()

        // Assert
        assertEquals(evPointsEntities, result)
        verify(evPointsDao).getEvPoints()
    }

    @Test
    fun updatePoints_updatesData() = runBlocking {
        // Arrange
        val evPointsEntities = listOf(fakeEvPointsEntity())
        val evPointLocalDataSourceImpl = EvPointLocalDataSource(evPointsDao)

        // Act
        evPointLocalDataSourceImpl.updatePoints(evPointsEntities)

        // Assert
        verify(evPointsDao).insert(evPointsEntities)
    }
}