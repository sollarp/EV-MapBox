package com.example.evmapbox.data.remote.OpenMapDto

import androidx.annotation.Keep
import com.example.evmapbox.data.Connection
import com.google.gson.annotations.SerializedName

@Keep
data class ConnectionNetworkDto(
    @SerializedName("ConnectionType") val connectionType: ConnectionType?,
    @SerializedName("StatusType") val statusType: StatusType?,
    @SerializedName("LevelID") val powerLevelId: Int?,
    @SerializedName("Level") val powerLevel: PowerLevel?,
    @SerializedName("PowerKW") val power: Double?,
    @SerializedName("Quantity") val quantity: Int,
)

fun ConnectionNetworkDto.toDomainModel(): Connection {
    return Connection(
        connectionFormalName = this.connectionType?.formalName ?: "",
        connectionTitle = this.connectionType?.title ?: "",
        statusTitle = this.statusType?.title ?: "",
        isOperationalStatus = this.statusType?.isOperational,
        powerLevel = this.powerLevelId ?: 1,
        powerLevelTitle = powerLevel?.title,
        power = this.power?.toString() ?: "",
        quantity = this.quantity
    )
}
