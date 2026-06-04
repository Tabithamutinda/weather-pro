package com.example.weatherpro.core.location

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class LocationTracker(
    private val context: Context
) {

    @SuppressLint("MissingPermission")
    suspend fun getCurrentLocation():
            Pair<Double, Double>? {

        val client =
            LocationServices
                .getFusedLocationProviderClient(
                    context
                )

        return suspendCancellableCoroutine { continuation ->

            client.lastLocation
                .addOnSuccessListener { location ->

                    if (location != null) {

                        continuation.resume(
                            Pair(
                                location.latitude,
                                location.longitude
                            )
                        )

                    } else {

                        continuation.resume(null)
                    }
                }
                .addOnFailureListener {

                    continuation.resume(null)
                }
        }
    }
}