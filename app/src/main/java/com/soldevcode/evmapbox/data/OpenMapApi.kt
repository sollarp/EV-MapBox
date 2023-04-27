package com.soldevcode.evmapbox.data

import com.soldevcode.evmapbox.domain.model.EvPointDetails
import com.soldevcode.evmapbox.util.Constants.OPEN_MAP_QUERY
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMapApi {
    @GET(OPEN_MAP_QUERY)
    suspend fun getMaxResults(
        @Query("longitude") longitude: Double,
        @Query("latitude") latitude: Double
    ): List<EvPointDetails>
}