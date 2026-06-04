package com.example.weatherpro.data.remote.dto

data class WeatherResponseDto(
    val location: LocationDto,
    val current: CurrentDto,
    val hourly: List<HourlyDto>,
    val daily: List<DailyDto>,
    val client_geo: ClientGeoDto
)