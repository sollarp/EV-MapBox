package com.example.evmapbox.domain.model

data class EvPointItems(
    val iD: Int?,
    val title: String?,
    val addressLine1: String?,
    val addressLine2: String?,
    val town: String?,
    val postcode: String?,
    val latitude: Double?,
    val longitude: Double?,
    val distance: Double?,
    val distanceUnit: Int?,
    val usageCost: String?,
    val connectionTypeID: List<Int?>?,
    val amps: List<Int?>?,
    val voltage: List<Int?>?,
    val powerKW: List<Int?>?
)


