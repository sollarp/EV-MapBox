package com.example.call_mapbox_api

import android.os.Parcelable
import com.example.call_mapbox_api.remote.ConnectionX
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConnectionList(
    val connectionItems: List<Connection>
) : Parcelable

@Parcelize
data class Connection(
    val ConnectionTypeID: Int?,
    val CurrentTypeID: Int?,
    val ID: Int?,
    val Voltage: Int?,
    val Amps: Int?,
    val LevelID: Int?,
    val PowerKW: Double?,
    val Quantity: Int?,
    val StatusTypeID: Int?
) : Parcelable

fun List<ConnectionX>.toConnections() : List<Connection> {
    return this.map {
        Connection(
            ConnectionTypeID = it.ConnectionTypeID,
            CurrentTypeID = it.CurrentTypeID,
            ID = it.ID,
            Voltage = it.Voltage,
            Amps = it.Amps,
            LevelID = it.LevelID,
            PowerKW = it.PowerKW,
            Quantity = it.Quantity,
            StatusTypeID = it.StatusTypeID
        )
    }
}