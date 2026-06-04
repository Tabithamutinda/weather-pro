package com.example.weatherpro.domain.usecase

import com.example.weatherpro.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(
        lat: Double,
        lon: Double
    ) =
        repository.getWeather(
            lat,
            lon
        )
}