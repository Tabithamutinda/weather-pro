package com.example.weatherpro.domain.model

data class Weather(

    val city: String,

    val country: String,

    val date: String,

    val timezone: String,

    val temperature: Double,

    val feelsLike: Double,

    val humidity: Int,

    val windSpeed: Double,

    val windDirection: Int,

    val windGust: Double,

    val uvIndex: Double,

    val conditionCode: String,

    val iconUrl: String,

    val high: Double,

    val low: Double,

    val sunrise: String,

    val sunset: String,

    val precipitationProbability: Int,

    val hourly: List<HourlyWeather>,

    val daily: List<DailyWeather>
)