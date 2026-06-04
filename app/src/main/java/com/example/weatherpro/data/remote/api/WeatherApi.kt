package com.example.weatherpro.data.remote.api

import com.example.weatherpro.data.remote.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/weather")
    suspend fun getWeather(

        @Query("lat")
        latitude: Double,

        @Query("lon")
        longitude: Double,

        @Query("days")
        days: Int = 7

    ): WeatherResponseDto

    @GET("v1/forecast")

    suspend fun getForecast(

        @Query("lat") latitude: Double,

        @Query("lon") longitude: Double,

        @Query("days") days: Int = 1

    ):WeatherResponseDto
}