package com.example.evmapbox.data.remote

import com.example.evmapbox.data.remote.OpenMapDto.ChargingStationNetworkDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMapApi {
    @GET("v3/poi/?key=22dcf268-f3e1-4cf4-a152-111d68e9502d/output=json&maxresults=1&compact=true&verbose=false&longitude=-1.260406976465403&latitude=51.754015044041914")
    suspend fun getMaxResults(): List<ChargingStationNetworkDto>

    @GET("v3/poi/?key=22dcf268-f3e1-4cf4-a152-111d68e9502d/output=json&compact=true&verbose=false")
    suspend fun getDistance(@Query("distance") distance: Number,
                            @Query("latitude") latitude: Double,
                            @Query("longitude") longitude: Double
    ): List<ChargingStationNetworkDto>

}