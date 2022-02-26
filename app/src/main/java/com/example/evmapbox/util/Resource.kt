package com.example.evmapbox.util

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>() : Resource<T>()
    class Error<T>(data: T? = null) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}