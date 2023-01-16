package com.example.call_mapbox_api.remote


import androidx.annotation.Keep
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.model.EvPointIds
import kotlinx.serialization.Serializable

@Keep
//@Parcelize
//@JsonClass(generateAdapter = true)
@Serializable
data class EvPointsBrakeItemX(
    val AddressInfo: AddressInfoX?,
    val Connections: List<ConnectionX>?,
    val DataProviderID: Int?,
    val DataQualityLevel: Int?,
    val DateCreated: String?,
    val DateLastStatusUpdate: String?,
    val DateLastVerified: String?,
    val ID: Int?,
    val IsRecentlyVerified: Boolean?,
    val NumberOfPoints: Int?,
    val OperatorID: Int?,
    val OperatorsReference: String?,
    val StatusTypeID: Int?,
    val SubmissionStatusTypeID: Int?,
    val UUID: String?,
    val UsageCost: String?,
    val UsageTypeID: Int?
)



fun List<EvPointsBrakeItemX>.toEvPointIds() : List<EvPointIds> {
    return this.map {
        EvPointIds(
            ID = it.ID
        )
    }
}

fun List<EvPointsBrakeItemX>.toEvPointDetails() : List<EvPointDetails> {
    return this.map {
        EvPointDetails(
            Connection = it.Connections,
            AddressInfo =it.AddressInfo,
            DataProviderID = it.DataProviderID,
            DataQualityLevel = it.DataQualityLevel,
            DateCreated = it.DateCreated,
            DateLastStatusUpdate = it.DateLastStatusUpdate,
            DateLastVerified = it.DateLastVerified,
            ID = it.ID,
            IsRecentlyVerified = it.IsRecentlyVerified,
            NumberOfPoints = it.NumberOfPoints,
            OperatorID = it.OperatorID,
            StatusTypeID = it.StatusTypeID,
            SubmissionStatusTypeID = it.SubmissionStatusTypeID,
            UUID = it.UUID,
            UsageCost = it.UsageCost,
            UsageTypeID = it.UsageTypeID

        )
    }
}
