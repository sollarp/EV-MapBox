package com.example.call_mapbox_api.data.remote


import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.serialization.Serializable

@Keep
@Serializable
@Entity(tableName = "evPointsDb")
data class EvPointsBrakeItem(
    @PrimaryKey(autoGenerate = false)
    val ID: Int?,

    @ColumnInfo(name = "data_last_verified")
    val DateLastVerified: String,

    @ColumnInfo(name = "data_provider_id")
    val DataProviderID: Int?,

    @ColumnInfo(name = "data_quality_level")
    val DataQualityLevel: Int?,

    @ColumnInfo(name = "data_created")
    val DateCreated: String?,

    @ColumnInfo(name = "data_last_status_update")
    val DateLastStatusUpdate: String?,

    @ColumnInfo(name = "number_of_points")
    val NumberOfPoints: Int?,

    @ColumnInfo(name = "is_recently_verified")
    val IsRecentlyVerified: Boolean?,

    @ColumnInfo(name = "operator_id")
    val OperatorID: Int?,

    @ColumnInfo(name = "status_type_id")
    val StatusTypeID: Int?,

    @ColumnInfo(name = "submission_status_type_id")
    val SubmissionStatusTypeID: Int?,

    @ColumnInfo(name = "uuid")
    val UUID: String?,

    @ColumnInfo(name = "usage_cost")
    val UsageCost: String?,

    @ColumnInfo(name = "usage_type_id")
    val UsageTypeID: Int?,

    @ColumnInfo(name = "connection")
    val Connections: List<Connections>,

    @ColumnInfo(name = "address_info")
    val AddressInfo: AddressInfo
)


fun List<EvPointsBrakeItem>.toEvPointDetails() : List<EvPointDetails> {
    return this.map {
        EvPointDetails(
            AddressInfo = it.AddressInfo,
            Connections = it.Connections,
            NumberOfPoints = it.NumberOfPoints,
            ID = it.ID,
            StatusTypeID = it.StatusTypeID,
            UsageCost = it.UsageCost,
            UUID = it.UUID,
            OperatorID = it.OperatorID,
            IsRecentlyVerified = it.IsRecentlyVerified,
            DataProviderID = it.DataProviderID,
            DataQualityLevel = it.DataQualityLevel,
            DateCreated = it.DateCreated,
            DateLastStatusUpdate = it.DateLastStatusUpdate,
            DateLastVerified = it.DateLastVerified,
            UsageTypeID = it.UsageTypeID,
            SubmissionStatusTypeID = it.SubmissionStatusTypeID
        )
    }
}