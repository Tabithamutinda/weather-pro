package com.example.weatherpro.domain.model

data class HourlyWeather(

    val time: String,

    val temperature: Double,

    val precipitationProbability: Int,

    val humidity: Int,

    val windSpeed: Double,

    val uvIndex: Double,

    val iconUrl: String,

    val conditionCode: String
)