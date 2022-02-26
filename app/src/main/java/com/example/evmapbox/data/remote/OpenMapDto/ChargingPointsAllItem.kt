package com.example.evmapbox.data.remote.OpenMapDto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.example.evmapbox.domain.model.EvPointItems


@Keep
data class ChargingPointsAllItem(
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
    val connections: List<Connection>?,
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
)
fun ChargingPointsAllItem.toEvPointItems(): EvPointItems {

    return EvPointItems(
        iD = iD,
        powerKW = connections?.map { it.powerKW },
        amps = connections?.map { it.amps },
        connectionTypeID = connections?.map { it.connectionTypeID },
        postcode = addressInfo?.postcode,
        latitude = addressInfo?.latitude,
        longitude = addressInfo?.longitude,
        addressLine1 = addressInfo?.addressLine1,
        addressLine2 = addressInfo?.addressLine2,
        distanceUnit = addressInfo?.distanceUnit,
        voltage = connections?.map { it.amps },
        usageCost = usageCost,
        title = addressInfo?.title,
        town = addressInfo?.town,
        distance = addressInfo?.distance
    )
}