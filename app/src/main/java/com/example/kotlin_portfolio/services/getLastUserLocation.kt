/*
package com.example.kotlin_portfolio.services

import android.annotation.SuppressLint

*/
/**
 * Retrieves the last known user location asynchronously.
 *
 * @param onGetLastLocationSuccess Callback function invoked when the location is successfully retrieved.
 *        It provides a Pair representing latitude and longitude.
 * @param onGetLastLocationFailed Callback function invoked when an error occurs while retrieving the location.
 *        It provides the Exception that occurred.
 *//*

@SuppressLint("MissingPermission")
private fun getLastUserLocation(
    onGetLastLocationSuccess: (Pair<Double, Double>) -> Unit,
    onGetLastLocationFailed: (Exception) -> Unit
) {
    // Check if location permissions are granted
    if (areLocationPermissionsGranted()) {
        // Retrieve the last known location
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location ->
                location?.let {
                    // If location is not null, invoke the success callback with latitude and longitude
                    onGetLastLocationSuccess(Pair(it.latitude, it.longitude))
                }
            }
            .addOnFailureListener { exception ->
                // If an error occurs, invoke the failure callback with the exception
                onGetLastLocationFailed(exception)
            }
    }
}*/
