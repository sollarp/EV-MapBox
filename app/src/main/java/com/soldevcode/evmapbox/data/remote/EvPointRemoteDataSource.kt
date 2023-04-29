package com.soldevcode.evmapbox.data.remote

import com.soldevcode.evmapbox.data.OpenMapApi
import com.soldevcode.evmapbox.domain.model.EvPointDetails
import com.soldevcode.evmapbox.util.LocationProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EvPointRemoteDataSource
@Inject constructor(private val openMapApi: OpenMapApi) {

    suspend fun getLatestEvPoint(): Flow<List<EvPointDetails>> {
        return flow {
            val result = openMapApi.getMaxResults(
                LocationProvider.longitude,
                LocationProvider.latitude
            )
            println("all data returned : $result")
            emit(result) // Emits the result of the request to the flow
        }
    }
}
