package com.example.call_mapbox_api.util

import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.remote.EvPointsBrakeItemX
import com.example.call_mapbox_api.remote.toEvPointDetails
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement


fun EvApiParser(jsonResult: List<EvPointsBrakeItemX>): List<EvPointDetails> {
    val json = Json { ignoreUnknownKeys = true }
    val resultToJson = json.encodeToJsonElement(jsonResult)
    val resultFromJson = json.decodeFromJsonElement<List<EvPointsBrakeItemX>>(resultToJson)
    val listOfPoints = resultFromJson.toEvPointDetails()
    return listOfPoints
}