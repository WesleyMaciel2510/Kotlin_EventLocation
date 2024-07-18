package com.example.kotlin_portfolio.services

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

fun openGoogleMaps(context: Context, latitude: String, longitude: String, destination: String? = null) {
    //val eventLocation = "Av. Leopoldino de Oliveira - Mercês, Uberaba - MG, 38060-010"

    Log.d("GoogleMaps", "openGoogleMaps called!")
    val uriString = if (destination.isNullOrEmpty()) {
        "http://maps.google.com/maps?saddr=${latitude},${longitude}"
    } else {
        "http://maps.google.com/maps?saddr=${latitude},${longitude}&daddr=$destination"
    }
    val uri = Uri.parse(uriString)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.setPackage("com.google.android.apps.maps")
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        Log.e("GoogleMaps", "Error opening Google Maps", e)
    }
}
