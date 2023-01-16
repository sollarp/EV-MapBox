package com.example.call_mapbox_api.data.remote


import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class AddressInfo(
    val AddressLine1: String?,
    val AddressLine2: String?,
    val CountryID: Int?,
    val DistanceUnit: Int?,
    val Distance: Double?,
    val ID: Int?,
    val Latitude: Double?,
    val Longitude: Double?,
    val Postcode: String?,
    val StateOrProvince: String?,
    val Title: String?,
    val Town: String?
)
