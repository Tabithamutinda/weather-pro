package com.example.weatherpro.domain.model

data class DailyWeather(

    val date: String,

    val minTemperature: Double,

    val maxTemperature: Double,

    val precipitationProbability: Int,

    val precipitationSum: Double,

    val windMax: Double,

    val sunrise: String,

    val sunset: String,

    val iconUrl: String,

    val conditionCode: String
)