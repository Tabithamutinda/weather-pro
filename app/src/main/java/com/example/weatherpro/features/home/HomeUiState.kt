package com.example.weatherpro.features.home

import com.example.weatherpro.domain.model.DailyWeather
import com.example.weatherpro.domain.model.HourlyWeather

data class HomeUiState(

    val isLoading: Boolean = false,

    val city: String = "",

    val country: String = "",

    val date: String = "",

    val timezone: String = "",

    val temperature: String = "",

    val feelsLike: String = "",

    val conditionCode: String = "",

    val iconUrl: String = "",

    val humidity: String = "",

    val windSpeed: String = "",

    val windDirection: String = "",

    val windGust: String = "",

    val uvIndex: String = "",

    val high: String = "",

    val low: String = "",

    val sunrise: String = "",

    val sunset: String = "",

    val precipitationProbability: String = "",

    val hourly: List<HourlyWeather> = emptyList(),

    val daily: List<DailyWeather> = emptyList(),

    val latitude: Double? = null,

    val longitude: Double? = null,

    val error: String? = null
)