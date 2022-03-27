package com.example.evmapbox.presentation

import com.example.evmapbox.data.ChargingStation
import com.example.evmapbox.domain.model.EvPointItems

data class EvListState(
    val isLoading: Boolean = false,
    val points: List<ChargingStation> = emptyList(),
    val error: String = ""
)
