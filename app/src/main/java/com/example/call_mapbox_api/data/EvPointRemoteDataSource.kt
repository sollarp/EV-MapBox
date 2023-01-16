package com.example.call_mapbox_api.data

import android.util.Log
import com.example.call_mapbox_api.data.remote.EVPointApiResponse
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class EvPointRemoteDataSource
@Inject constructor(private val openMapApi: OpenMapApi) : IEvPointRemoteDataSource {

    override suspend fun getLatestEvPoint(): Flow<List<EvPointDetails>> {

        try {
            EVPointApiResponse(
                body = openMapApi.getMaxResults()
                   // emit(result) // Emits the result of the request to the flow
                    //delay(refreshIntervalMs) // Suspends the coroutine for some time
            )
        } catch (e: HttpException) {
            Log.d("EvPointRemoteDataSource", "server error")
            EVPointApiResponse(
                httpCode = e.code(),
                errorMessage = "server error"
            )
        } catch (e: IOException) {
            Log.d("EvPointRemoteDataSource", "connection error")
            EVPointApiResponse(
                errorMessage = "connection error"
            )
        }
        return flow {
            val result = openMapApi.getMaxResults()
            emit(result)
        }
    }
}

interface IEvPointRemoteDataSource {
    suspend fun getLatestEvPoint(): Flow<List<EvPointDetails>>
}

