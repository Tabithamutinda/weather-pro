package com.example.weatherpro.domain.repository

import com.example.weatherpro.domain.model.Weather

interface ForecastRepository {
    suspend fun getForecast(
        lat: Double,
        lon: Double
    ): Weather
}