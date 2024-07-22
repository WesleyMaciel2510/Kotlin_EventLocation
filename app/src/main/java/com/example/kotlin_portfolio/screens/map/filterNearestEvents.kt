package com.example.kotlin_portfolio.screens.map

import android.annotation.SuppressLint
import android.util.Log
import com.example.kotlin_portfolio.utils.AllEvents
import com.example.kotlin_portfolio.utils.AllEventsItem
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

@SuppressLint("DefaultLocale")
fun findNearestEvents(userLatitude: Double?, userLongitude: Double?): List<AllEventsItem> {
    Log.d("Location", "findNearestEvents called!")

    // Ensure latitude and longitude are not null
    if (userLatitude == null || userLongitude == null) {
        return emptyList()  // Return an empty list if coordinates are not available
    }

    // Haversine function to calculate distance between two points on Earth
    fun haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val R = 6372.8 // Earth radius in kilometers
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a = sin(dLat / 2).pow(2) + sin(dLon / 2).pow(2) * cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2))
        val c = 2 * asin(sqrt(a))
        return R * c
    }

    val filteredEvents = AllEvents
        .map { event ->
            event.geolocation.let { geo ->
                val distance = haversine(userLatitude, userLongitude, geo.latitude, geo.longitude)
                //Pair(event, distance)
                event.copy(distance = String.format("%.2f km", distance))
            }
        }
        .take(5)
        .sortedBy { it.distance }
        .take(5)
        /*.sortedBy { it.second }
        .map { it.first }*/

    Log.d("Location", "@ filteredEvents = $filteredEvents")

    return filteredEvents
}

