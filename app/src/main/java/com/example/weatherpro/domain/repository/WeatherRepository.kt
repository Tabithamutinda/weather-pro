package com.example.weatherpro.domain.repository

import com.example.weatherpro.domain.model.Weather

interface WeatherRepository {

    suspend fun getWeather(
        lat: Double,
        lon: Double
    ): Weather
}