package com.example.evmapbox.data.remote.OpenMapDto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ConnectionType(
    @SerializedName("FormalName") val formalName: String?,
    @SerializedName("Title") val title: String?
)
