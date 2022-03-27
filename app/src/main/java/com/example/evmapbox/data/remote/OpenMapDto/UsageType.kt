package com.example.evmapbox.data.remote.OpenMapDto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UsageType(
    @SerializedName("Title") val title: String,
    @SerializedName("IsPayAtLocation") val isPayAtLocation: Boolean,
    @SerializedName("IsMembershipRequired") val isMembershipRequired: Boolean
)
