package com.example.call_mapbox_api.remote


import android.os.Parcel
import androidx.annotation.Keep
import android.os.Parcelable
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class AddressInfoX(
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
