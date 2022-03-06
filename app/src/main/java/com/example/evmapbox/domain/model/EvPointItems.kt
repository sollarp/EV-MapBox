package com.example.evmapbox.domain.model

import com.example.evmapbox.data.remote.OpenMapDto.AddressInfo

data class EvPointItems(
    val iD: Int?,
    val operatorID: Int?,
    val usageCost: String?,
    val addressInfo: AddressInfo?,
)

