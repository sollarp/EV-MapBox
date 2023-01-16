package com.example.call_mapbox_api.model

import com.example.call_mapbox_api.remote.AddressInfoX
import com.example.call_mapbox_api.remote.ConnectionX
import kotlinx.serialization.Serializable

@Serializable
data class EvPointDetails(
    val DataProviderID: Int?,
    val DataQualityLevel: Int?,
    val DateCreated: String?,
    val DateLastStatusUpdate: String?,
    val DateLastVerified: String?,
    val ID: Int?,
    val IsRecentlyVerified: Boolean?,
    val NumberOfPoints: Int?,
    val OperatorID: Int?,
    val StatusTypeID: Int?,
    val SubmissionStatusTypeID: Int?,
    val UUID: String?,
    val UsageCost: String?,
    val UsageTypeID: Int?,
    val AddressInfo: AddressInfoX?,
    val Connection: List<ConnectionX>?
)