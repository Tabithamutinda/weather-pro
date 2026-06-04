package com.example.weatherpro.data.repository

import com.example.weatherpro.data.remote.api.WeatherApi
import com.example.weatherpro.data.remote.mapper.toDomain
import com.example.weatherpro.domain.model.DailyWeather
import com.example.weatherpro.domain.model.HourlyWeather
import com.example.weatherpro.domain.model.Weather
import com.example.weatherpro.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(
        lat: Double,
        lon: Double
    ): Weather {

        return api.getWeather(

            latitude = lat,

            longitude = lon

        ).toDomain()
    }

    override suspend fun getForecast(
        lat: Double,
        lon: Double
    ): Weather {

        val response =
            api.getForecast(
                latitude = lat,
                longitude = lon,
                days = 7
            )

        return response.toDomain()
    }
}