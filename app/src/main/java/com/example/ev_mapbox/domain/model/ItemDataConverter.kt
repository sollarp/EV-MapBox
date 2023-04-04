package com.example.ev_mapbox.domain.model

import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.data.remote.dto.Connections
import java.io.Serializable

data class ItemDataConverter(
    val AddressLine1: String?,
    val AddressLine2: String?,
    val Latitude: Double?,
    val Longitude: Double?,
    val Postcode: String?,
    val Title: String?,
    val Town: String?,
    var UsageCost: String?,
    val NumberOfPoints: Int?,
    val DateLastStatusUpdate: String?,
    val Connection: List<Connections>?
): Serializable

fun itemDataConverter(address: EvPointsEntity): ItemDataConverter {
    return ItemDataConverter(
        address.AddressInfo.AddressLine1,
        address.AddressInfo.AddressLine2,
        address.AddressInfo.Longitude,
        address.AddressInfo.Latitude,
        address.AddressInfo.Postcode,
        address.AddressInfo.Title,
        address.AddressInfo.Town,
        address.UsageCost,
        address.NumberOfPoints,
        address.DateLastStatusUpdate,
        address.Connections
    )
}

