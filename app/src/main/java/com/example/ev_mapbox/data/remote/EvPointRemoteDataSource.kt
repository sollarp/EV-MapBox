package com.example.ev_mapbox.data.remote

import com.example.ev_mapbox.data.OpenMapApi
import com.example.ev_mapbox.domain.model.EvPointDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EvPointRemoteDataSource
@Inject constructor(private val openMapApi: OpenMapApi) {

    suspend fun getLatestEvPoint(): Flow<List<EvPointDetails>> {
        return flow {
            val result = openMapApi.getMaxResults()
            emit(result) // Emits the result of the request to the flow
        }
    }
}