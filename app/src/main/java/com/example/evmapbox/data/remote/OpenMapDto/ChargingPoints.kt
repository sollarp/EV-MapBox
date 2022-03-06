package com.example.evmapbox.data.remote.OpenMapDto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.example.evmapbox.domain.model.EvPointItems

class ChargingPoints : ArrayList<ChargingPoints.ChargingPointsItem>(){
    @Keep
    data class ChargingPointsItem(
        @SerializedName("IsRecentlyVerified")
        val isRecentlyVerified: Boolean?,
        @SerializedName("ID")
        val iD: Int?,
        @SerializedName("UUID")
        val uUID: String?,
        @SerializedName("DataProviderID")
        val dataProviderID: Int?,
        @SerializedName("OperatorID")
        val operatorID: Int?,
        @SerializedName("OperatorsReference")
        val operatorsReference: String?,
        @SerializedName("UsageTypeID")
        val usageTypeID: Int?,
        @SerializedName("UsageCost")
        val usageCost: String?,
        @SerializedName("AddressInfo")
        val addressInfo: AddressInfo?,
        @SerializedName("Connections")
        val connections: List<Connection?>?,
        @SerializedName("NumberOfPoints")
        val numberOfPoints: Int?,
        @SerializedName("StatusTypeID")
        val statusTypeID: Int?,
        @SerializedName("DateLastStatusUpdate")
        val dateLastStatusUpdate: String?,
        @SerializedName("DataQualityLevel")
        val dataQualityLevel: Int?,
        @SerializedName("DateCreated")
        val dateCreated: String?,
        @SerializedName("SubmissionStatusTypeID")
        val submissionStatusTypeID: Int?
    ) {
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
    
        @Keep
        data class Connection(
            @SerializedName("ID")
            val iD: Int?,
            @SerializedName("ConnectionTypeID")
            val connectionTypeID: Int?,
            @SerializedName("StatusTypeID")
            val statusTypeID: Int?,
            @SerializedName("LevelID")
            val levelID: Int?,
            @SerializedName("Amps")
            val amps: Int?,
            @SerializedName("Voltage")
            val voltage: Int?,
            @SerializedName("PowerKW")
            val powerKW: Double?,
            @SerializedName("CurrentTypeID")
            val currentTypeID: Int?,
            @SerializedName("Quantity")
            val quantity: Int?
        )
    }
}
