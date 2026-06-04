package com.example.weatherpro.data.remote.dto

data class LocationDto(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val requested_lat: Double,
    val requested_lon: Double,
    val country: String
)