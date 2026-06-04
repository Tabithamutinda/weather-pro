package com.example.weatherpro.data.repository

import com.example.weatherpro.data.remote.api.WeatherApi
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

        val response =
            api.getWeather(
                latitude = lat,
                longitude = lon
            )

        val today =
            response.daily.first()

        return Weather(

            city = "Nairobi",

            country =
                response.location.country,

            date =
                today.date,

            timezone =
                response.location.timezone,

            temperature =
                response.current.temperature,

            feelsLike =
                response.current.feelsLike,

            humidity =
                response.current.humidity,

            windSpeed =
                response.current.windSpeed,

            windDirection =
                response.current.windDirection,

            windGust =
                response.current.windGust,

            uvIndex =
                response.current.uvIndex,

            conditionCode =
                response.current.conditionCode,

            iconUrl =
                response.current.icon,

            high =
                today.tempMax,

            low =
                today.tempMin,

            sunrise =
                today.sunrise,

            sunset =
                today.sunset,

            precipitationProbability =
                today.precipitationProbability,

            hourly =
                response.hourly.map {

                    HourlyWeather(

                        time = it.time,

                        temperature =
                            it.temperature,

                        precipitationProbability =
                            it.precipitationProbability,

                        humidity =
                            it.humidity,

                        windSpeed =
                            it.windSpeed,

                        uvIndex =
                            it.uvIndex,

                        iconUrl =
                            it.icon,

                        conditionCode =
                            it.conditionCode
                    )
                },

            daily =
                response.daily.map {

                    DailyWeather(

                        date =
                            it.date,

                        minTemperature =
                            it.tempMin,

                        maxTemperature =
                            it.tempMax,

                        precipitationProbability =
                            it.precipitationProbability,

                        precipitationSum =
                            it.precipitationSum,

                        windMax =
                            it.windMax,

                        sunrise =
                            it.sunrise,

                        sunset =
                            it.sunset,

                        iconUrl =
                            it.icon,

                        conditionCode =
                            it.conditionCode
                    )
                }
        )
    }
}