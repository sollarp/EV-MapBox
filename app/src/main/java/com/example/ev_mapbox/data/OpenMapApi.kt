package com.example.ev_mapbox.data

import com.example.ev_mapbox.domain.model.EvPointDetails
import com.example.ev_mapbox.util.Constants.MOCK_RESOURCE_PATH
import com.example.ev_mapbox.util.Constants.OPEN_MAP_QUERY
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMapApi {
    @GET(OPEN_MAP_QUERY)
    suspend fun getMaxResults(
        @Query("longitude") longitude: Double,
        @Query("latitude") latitude: Double
    ): List<EvPointDetails>
}