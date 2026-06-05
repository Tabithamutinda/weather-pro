package com.example.weatherpro.features.home

import com.example.weatherpro.domain.model.DailyWeather
import com.example.weatherpro.domain.model.HourlyWeather

data class HomeState(

    val isLoading: Boolean = false,

    val city: String = "",

    val country: String = "",

    val date: String = "",

    val timezone: String = "",

    val temperature: String = "",

    val feelsLike: String = "",

    val humidity: String = "",

    val windSpeed: String = "",

    val windDirection: String = "",

    val windGust: String = "",

    val uvIndex: String = "",

    val conditionCode: String = "",

    val iconUrl: String = "",

    val high: String = "",

    val low: String = "",

    val sunrise: String = "",

    val sunset: String = "",

    val precipitationProbability: String = "",

    val hourly: List<HourlyWeather> = emptyList(),

    val daily: List<DailyWeather> = emptyList(),

    val error: String? = null
)

sealed interface HomeIntent {

    data class LoadWeather(
        val latitude: Double,
        val longitude: Double
    ) : HomeIntent
}

sealed interface HomeEvent {

    data class ShowError(
        val message: String
    ) : HomeEvent
}