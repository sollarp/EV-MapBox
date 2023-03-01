package com.example.ev_mapbox.data

import com.example.ev_mapbox.domain.model.EvPointDetails
import com.example.ev_mapbox.util.Constants.MOCK_RESOURCE_PATH
import retrofit2.http.GET

interface OpenMapApi {
    @GET(MOCK_RESOURCE_PATH)
    suspend fun getMaxResults(): List<EvPointDetails>

    //@GET("v3/poi/?key=22dcf268-f3e1-4cf4-a152-111d68e9502d/output=json&maxresults=1&compact=true&verbose=false&longitude=-1.360406976465403&latitude=51.954015044041914")

//    @GET("v3/poi/?key=22dcf268-f3e1-4cf4-a152-111d68e9502d/output=json&compact=true&verbose=false")
//    suspend fun getDistance(@Query("distance") distance: Number,
//                            @Query("latitude") latitude: Double,
//                            @Query("longitude") longitude: Double
//    ): List<EvPointsBrakeItemX>>>

}
