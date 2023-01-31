package com.example.call_mapbox_api.util

/*
This algorithm uses the Haversine formula to calculate the great-circle distance
between two points on the Earth's surface. The inputs are the latitude and longitude
coordinates of two points (lat1, lng1, lat2, lng2)
and the output is the distance between them in kilometers.
*/

fun distanceInKm(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Double {
    val earthRadius = 6371.0
    val latDiff = Math.toRadians(lat2 - lat1)
    val lngDiff = Math.toRadians(lng2 - lng1)
    val a =
        Math.sin(latDiff / 2) * Math.sin(latDiff / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(
            Math.toRadians(lat2)
        ) * Math.sin(lngDiff / 2) * Math.sin(lngDiff / 2)
    val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
    return earthRadius * c
}
