package com.example.evmapbox.data

import com.example.evmapbox.data.remote.OpenMapApi
import com.example.evmapbox.data.remote.OpenMapDto.ChargingPointsAllItem
import com.example.evmapbox.domain.repository.EvMapRepo
import retrofit2.Response
import javax.inject.Inject


class EvRepoImpl @Inject constructor(
    private val openMapApi: OpenMapApi,
): EvMapRepo {

    override suspend fun getResponse(): List<ChargingPointsAllItem> {
        return openMapApi.getMaxResults()
    }
    fun provideTestString1() = "This is a string we will inject"
}