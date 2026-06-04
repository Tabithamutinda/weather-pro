package com.example.weatherpro.data.remote.mapper

import com.example.weatherpro.data.remote.dto.WeatherResponseDto
import com.example.weatherpro.domain.model.DailyWeather
import com.example.weatherpro.domain.model.HourlyWeather
import com.example.weatherpro.domain.model.Weather

fun WeatherResponseDto.toDomain(): Weather {

    return Weather(

        city = location.country,

        country = location.country,

        timezone = location.timezone,

        date = current.time,

        temperature = current.temperature,

        feelsLike = current.feelsLike,

        humidity = current.humidity,

        windSpeed = current.windSpeed,

        windDirection = current.windDirection,

        windGust = current.windGust,

        uvIndex = current.uvIndex,

        conditionCode = current.conditionCode,

        iconUrl = current.icon,

        high = daily.firstOrNull()?.tempMax ?: 0.0,

        low = daily.firstOrNull()?.tempMin ?: 0.0,

        sunrise = daily.firstOrNull()?.sunrise.orEmpty(),

        sunset = daily.firstOrNull()?.sunset.orEmpty(),

        precipitationProbability =
            daily.firstOrNull()?.precipitationProbability
                ?: 0,

        hourly = hourly.map {

            HourlyWeather(

                time = it.time,

                temperature = it.temperature,

                precipitationProbability =
                    it.precipitationProbability,

                humidity = it.humidity,

                windSpeed = it.windSpeed,

                uvIndex = it.uvIndex,

                iconUrl = it.icon,

                conditionCode = it.conditionCode,


            )
        },

        daily = daily.map {

            DailyWeather(

                date = it.date,

                minTemperature = it.tempMin,

                maxTemperature = it.tempMax,



                precipitationProbability =
                    it.precipitationProbability,

                precipitationSum = it.precipitationSum,
                windMax = it.windMax,


                sunrise = it.sunrise,

                sunset = it.sunset,
                iconUrl = it.icon,
                conditionCode = it.conditionCode,

            )
        }
    )
}