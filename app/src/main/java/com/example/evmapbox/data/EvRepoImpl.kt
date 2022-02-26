package com.example.evmapbox.data

import com.example.evmapbox.data.remote.OpenMapApi
import com.example.evmapbox.data.remote.OpenMapDto.ChargingPointsAllItem
import com.example.evmapbox.domain.repository.EvMapRepo
import javax.inject.Inject


class EvRepoImpl @Inject constructor(
    private val openMapApi: OpenMapApi): EvMapRepo {
    override suspend fun getResponse(): List<ChargingPointsAllItem> {
        return openMapApi.getDistance(distance = 2,
            longitude = -1.260406976465403,
            latitude = 51.754015044041914)
    }
}