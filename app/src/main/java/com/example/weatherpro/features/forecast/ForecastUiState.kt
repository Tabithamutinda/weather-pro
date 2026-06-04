package com.example.weatherpro.features.forecast

import com.example.weatherpro.domain.model.HourlyWeather

data class ForecastUiState(

    val isLoading: Boolean = false,

    val hourly: List<HourlyWeather> = emptyList(),

    val error: String? = null

)