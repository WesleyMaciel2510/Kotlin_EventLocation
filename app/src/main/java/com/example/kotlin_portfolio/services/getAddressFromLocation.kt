package com.example.kotlin_portfolio.services

import android.annotation.SuppressLint
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.os.Build
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Locale


@SuppressLint("UnrememberedMutableState")
suspend fun getAddressFromLocation(context: Context, latitude: Double, longitude: Double): String? {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addressDeferred = CompletableDeferred<String?>()

    withContext(Dispatchers.IO) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                geocoder.getFromLocation(latitude, longitude, 1, object : Geocoder.GeocodeListener {
                    override fun onGeocode(addresses: List<Address>) {
                        if (addresses.isNotEmpty()) {
                            addressDeferred.complete(addresses[0].getAddressLine(0))
                        } else {
                            addressDeferred.complete("No address found")
                        }
                    }

                    override fun onError(errorMessage: String?) {
                        addressDeferred.complete(null)
                    }
                })
            } else {
                TODO("VERSION.SDK_INT < TIRAMISU")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            addressDeferred.complete(null)
        }
    }

    return addressDeferred.await()
}