package com.example.weatherpro.domain.usecase

import com.example.weatherpro.domain.repository.WeatherRepository

import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(

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