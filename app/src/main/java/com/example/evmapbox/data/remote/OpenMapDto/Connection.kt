package com.example.evmapbox.data.remote.OpenMapDto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

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
    val powerKW: Int?,
    @SerializedName("CurrentTypeID")
    val currentTypeID: Int?,
    @SerializedName("Quantity")
    val quantity: Int?
)