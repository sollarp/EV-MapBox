package com.example.evmapbox.domain.repository
// This interface for testing purpose
import com.example.evmapbox.data.remote.OpenMapDto.ChargingPointsAllItem


interface EvMapRepo {

    suspend fun getResponse(): List<ChargingPointsAllItem>

}