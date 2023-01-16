package com.example.call_mapbox_api.data.repository

import android.util.Log
import com.example.call_mapbox_api.data.IEvPointRemoteDataSource
import com.example.call_mapbox_api.data.IEvPointLocalDataSource
import com.example.call_mapbox_api.data.remote.EvPointsBrakeItem
import com.example.call_mapbox_api.model.toEvPointsBreakItems
import kotlinx.coroutines.flow.Flow

class SearchListRepository(
    private val evPointDataSource: IEvPointRemoteDataSource,
    private val localDataSource: IEvPointLocalDataSource
) : ISearchListRepository {

    override suspend fun fetchList(): Flow<List<EvPointsBrakeItem>> {
        try {
            evPointDataSource.getLatestEvPoint().collect { items ->
                localDataSource.updatePoints(items.toEvPointsBreakItems())
            }
        } catch (e: Exception) {
            Log.d("SearchListRepository", "Connection failed using local data base")
        }
        return localDataSource.fetchPoints()
    }
}

interface ISearchListRepository {
    suspend fun fetchList(): Flow<List<EvPointsBrakeItem>>
}

