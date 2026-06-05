package com.example.weatherpro.features.forecast

import com.example.weatherpro.domain.model.HourlyWeather

object ForecastContract {

    sealed interface Intent {

        data class LoadForecast(
            val latitude: Double,
            val longitude: Double
        ) : Intent
    }

    data class State(

        val isLoading: Boolean = false,

        val hourly: List<HourlyWeather> = emptyList(),

        val error: String? = null
    )

    sealed interface Effect
}