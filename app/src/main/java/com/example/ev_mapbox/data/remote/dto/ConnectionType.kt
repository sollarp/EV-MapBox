package com.example.ev_mapbox.data.remote.dto

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ConnectionType(
    val FormalName: String,
    val ID: Int,
    val IsDiscontinued: Boolean,
    val IsObsolete: Boolean,
    val Title: String
)
