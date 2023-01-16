package com.example.call_mapbox_api.data.remote

import java.net.HttpURLConnection

data class EVPointApiResponse<T>(
    val httpCode: Int = HttpURLConnection.HTTP_OK,
    val body: T? = null,
    val errorMessage: String? = null,

    )
