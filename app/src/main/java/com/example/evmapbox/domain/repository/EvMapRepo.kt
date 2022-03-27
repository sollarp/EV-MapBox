package com.example.evmapbox.domain.repository
// This interface for testing purpose
import com.example.evmapbox.data.ChargingStation
import com.example.evmapbox.domain.model.DataResult


interface EvMapRepo {

    suspend fun getResponse(): DataResult<List<ChargingStation>>

}