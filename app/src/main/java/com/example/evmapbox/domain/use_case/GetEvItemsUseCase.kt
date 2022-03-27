package com.example.evmapbox.domain.use_case

import com.example.evmapbox.data.ChargingStation
import com.example.evmapbox.domain.model.DataResult
import com.example.evmapbox.domain.repository.EvMapRepo

import javax.inject.Inject

class GetEvPointUseCase @Inject constructor(
    private val evMapRepo: EvMapRepo
) {
    suspend operator fun invoke(): DataResult<List<ChargingStation>> {
        return evMapRepo.getResponse()
    }

}