/*
package com.example.kotlin_portfolio.services

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.Locale

fun getAddressFromLocation(context: Context, lat: Double, lon: Double, callback: (String) -> Unit) {
    var currentLocation by mutableStateOf<Location?>(null)

    try {
        currentLocation = locationTracker.getCurrentLocation()
        if (currentLocation != null) {
            //val address = addresses[0]
        }
    } catch (e: Exception) {
        Log.e("geocoder", "Failed to get address: ${e.message}")
        callback("Address not found")
    }
}*/
