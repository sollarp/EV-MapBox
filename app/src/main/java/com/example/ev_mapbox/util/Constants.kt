package com.example.ev_mapbox.util

import com.example.ev_mapbox.BuildConfig.EV_MAP_API_KEY

object Constants {
    const val MOCK_RESOURCE_PATH = "site"
    const val OPEN_MAP_QUERY = "?key=$EV_MAP_API_KEY/&output=json&distanceunit=Miles&distance=20"
    const val OPEN_MAP_BASE_URL = "https://api.openchargemap.io/v3/poi/"
    const val MOCK_BASE_URL = "https://6faa85ef-850a-4350-ad42-57a99afe99af.mock.pstmn.io/"
    const val API_KEY_ERROR =
        "You must specify an API Key, either in an X-API-Key header or key= query string parameter."
    const val SPAN_COUNT = 1
    const val SPAN_COUNT_2 = 2
    const val LOCATION_MESSAGE = "This app requires location permission to function properly."
    const val AGREE = "Agree"
    const val REQUEST_CODE_LOCATION_PERMISSION = 0
}

