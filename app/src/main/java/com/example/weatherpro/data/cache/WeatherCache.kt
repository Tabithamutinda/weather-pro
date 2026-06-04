package com.example.weatherpro.data.cache

import com.example.weatherpro.domain.model.DailyWeather
import com.example.weatherpro.domain.model.HourlyWeather
import com.example.weatherpro.domain.model.Weather

object WeatherCache {

    var weather: Weather? = null

    var forecast: Weather? = null

    var weatherLastUpdated: Long = 0L

    var forecastLastUpdated: Long = 0L
}