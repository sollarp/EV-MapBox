package com.example.evmapbox.data.remote

import com.example.evmapbox.data.remote.OpenMapDto.ChargingPointsAll
import com.example.evmapbox.data.remote.OpenMapDto.ChargingPointsAllItem
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMapApi {
    @GET("v3/poi/?key=22dcf268-f3e1-4cf4-a152-111d68e9502d/output=json&compact=true&verbose=false")
    suspend fun getMaxResults(@Query("maxresults") maxresults: Number,
                      @Query("latitude") latitude: Double,
                      @Query("longitude") longitude: Double): List<ChargingPointsAllItem>

    @GET("v3/poi/?key=22dcf268-f3e1-4cf4-a152-111d68e9502d/output=json&compact=true&verbose=false")
    suspend fun getDistance(@Query("distance") distance: Number,
                            @Query("latitude") latitude: Double,
                            @Query("longitude") longitude: Double
    ): List<ChargingPointsAllItem>

}