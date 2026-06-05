package com.example.weatherpro.data.repository

import com.example.weatherpro.data.cache.CacheConfig
import com.example.weatherpro.data.cache.WeatherCache
import com.example.weatherpro.data.remote.api.WeatherApi
import com.example.weatherpro.data.remote.mapper.toDomain
import com.example.weatherpro.domain.model.Weather
import com.example.weatherpro.domain.repository.ForecastRepository
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(

    private val api: WeatherApi

) : ForecastRepository {
    override suspend fun getForecast(
        lat: Double,
        lon: Double
    ): Weather {

        val now = System.currentTimeMillis()

        WeatherCache.forecast?.let {

            if (
                now - WeatherCache.forecastLastUpdated <
                CacheConfig.CACHE_DURATION
            ) {

                return it
            }
        }

        val response =
            api.getForecast(
                latitude = lat,
                longitude = lon
            )

        val weather =
            response.toDomain()

        WeatherCache.forecast =
            weather

        WeatherCache.forecastLastUpdated = now

        return weather
    }
}