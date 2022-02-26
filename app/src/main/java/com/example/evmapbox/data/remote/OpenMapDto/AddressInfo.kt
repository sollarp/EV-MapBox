package com.example.evmapbox.data.remote.OpenMapDto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.example.evmapbox.domain.model.EvPointItems


@Keep
data class AddressInfo(
    @SerializedName("ID")
    val iD: Int?,
    @SerializedName("Title")
    val title: String?,
    @SerializedName("AddressLine1")
    val addressLine1: String?,
    @SerializedName("AddressLine2")
    val addressLine2: String?,
    @SerializedName("Town")
    val town: String?,
    @SerializedName("StateOrProvince")
    val stateOrProvince: String?,
    @SerializedName("Postcode")
    val postcode: String?,
    @SerializedName("CountryID")
    val countryID: Int?,
    @SerializedName("Latitude")
    val latitude: Double?,
    @SerializedName("Longitude")
    val longitude: Double?,
    @SerializedName("Distance")
    val distance: Double?,
    @SerializedName("DistanceUnit")
    val distanceUnit: Int?
)
