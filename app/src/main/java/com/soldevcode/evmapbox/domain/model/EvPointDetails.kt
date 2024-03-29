package com.soldevcode.evmapbox.domain.model

import com.soldevcode.evmapbox.data.local.EvPointsEntity
import com.soldevcode.evmapbox.data.remote.dto.AddressInfo
import com.soldevcode.evmapbox.data.remote.dto.Connections
import kotlinx.serialization.Serializable

@Serializable
data class EvPointDetails(
    val ID: Int?,
    val DateLastVerified: String,
    val DataProviderID: Int?,
    val DataQualityLevel: Int?,
    val DateCreated: String?,
    val DateLastStatusUpdate: String?,
    val NumberOfPoints: Int?,
    val IsRecentlyVerified: Boolean?,
    val OperatorID: Int?,
    val StatusTypeID: Int?,
    val SubmissionStatusTypeID: Int?,
    val UUID: String?,
    val UsageCost: String?,
    val UsageTypeID: Int?,
    val Connections: List<Connections>,
    val AddressInfo: AddressInfo,
)

fun List<EvPointDetails>.toEvPointsBreakItems() : List<EvPointsEntity> {
    return this.map {
        EvPointsEntity(
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
            SubmissionStatusTypeID = it.SubmissionStatusTypeID,
        )
    }
}


