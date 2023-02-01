package com.example.call_mapbox_api.data.repository

import android.util.Log
import com.example.call_mapbox_api.data.local.EvPointLocalDataSource
import com.example.call_mapbox_api.data.remote.EvPointRemoteDataSource
import com.example.call_mapbox_api.data.remote.EvPointsEntity
import com.example.call_mapbox_api.model.toEvPointsBreakItems
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchListRepositoryImpl @Inject constructor(
    private val evPointDataSource: EvPointRemoteDataSource,
    private val localDataSource: EvPointLocalDataSource
) : ISearchListRepository {

    override suspend fun fetchList(): Flow<List<EvPointsEntity>> {
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