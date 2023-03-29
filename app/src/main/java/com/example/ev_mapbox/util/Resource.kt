package com.example.ev_mapbox.util

import com.example.ev_mapbox.domain.model.EvPointDetails
import kotlinx.coroutines.flow.Flow

sealed class Resource<T>(val data: Any? = null, val message: String? = null) {
    class Success<T>(data: Flow<List<EvPointDetails>>) : Resource<T>(data)
    class Error<T : Any>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T : Any>(data: T? = null) : Resource<T>(data)
    fun isDataAvailable(): Boolean {
        return data != null && data is Flow<*>
    }
}