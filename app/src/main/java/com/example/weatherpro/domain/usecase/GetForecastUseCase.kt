package com.example.weatherpro.domain.usecase

import com.example.weatherpro.domain.model.Weather
import com.example.weatherpro.domain.repository.WeatherRepository

class GetForecastUseCase(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(
        lat: Double,
        lon: Double
    ): Weather {

        return repository.getForecast(
            lat,
            lon
        )
    }
}