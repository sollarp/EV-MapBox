package com.example.call_mapbox_api.data.repository

import com.example.call_mapbox_api.data.local.EvPointLocalDataSource
import com.example.call_mapbox_api.data.local.EvPointsEntity
import com.example.call_mapbox_api.data.remote.EvPointRemoteDataSource
import com.example.call_mapbox_api.domain.model.EvPointDetails
import com.example.call_mapbox_api.domain.model.toEvPointsBreakItems
import com.example.call_mapbox_api.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchListRepositoryImpl @Inject constructor(
    private val evPointDataSource: EvPointRemoteDataSource,
    private val localDataSource: EvPointLocalDataSource
) : ISearchListRepository {

    override suspend fun fetchList(): Flow<List<EvPointsEntity>> {

        try {
            Resource.Loading<List<EvPointDetails>>()
            val getPoints = evPointDataSource.getLatestEvPoint()
                getPoints.collect { items ->
                localDataSource.updatePoints(items.toEvPointsBreakItems())
            }
            Resource.Success<List<EvPointDetails>>(getPoints)
        } catch (e: HttpException) {
            Resource.Error<EvPointDetails>(
                e.localizedMessage ?: "An unexpected error occurred"
            )
        } catch (e: IOException) {
            Resource.Error<List<EvPointDetails>>(
                "Couldn't reach server. Check your internet connection."
            )
        }
        return localDataSource.fetchPoints()
    }
}