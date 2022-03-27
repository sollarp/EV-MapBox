package com.example.evmapbox.data

import com.example.evmapbox.data.remote.OpenMapApi

import com.example.evmapbox.domain.model.DataResult
import com.example.evmapbox.domain.repository.EvMapRepo
import javax.inject.Inject


class EvRepoImpl @Inject constructor(
    private val openMapApi: OpenMapApi,
): EvMapRepo {

    fun provideTestString1() = "This is a string we will inject"
    override suspend fun getResponse(): DataResult<List<ChargingStation>> {
        TODO("Not yet implemented")
    }
}