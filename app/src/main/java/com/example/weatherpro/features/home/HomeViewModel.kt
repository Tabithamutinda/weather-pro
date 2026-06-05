package com.example.weatherpro.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherpro.core.util.DateFormatter
import com.example.weatherpro.core.util.ErrorHandler
import com.example.weatherpro.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow(HomeState())

    val state =
        _state.asStateFlow()

    fun onIntent(
        intent: HomeIntent
    ) {

        when (intent) {

            is HomeIntent.LoadWeather -> {

                loadWeather(
                    intent.latitude,
                    intent.longitude
                )
            }
        }
    }

    private fun loadWeather(
        latitude: Double,
        longitude: Double
    ) {

        viewModelScope.launch {

            try {

                _state.value =
                    _state.value.copy(
                        isLoading = true,
                        error = null
                    )

                val weather =
                    getWeatherUseCase(
                        latitude,
                        longitude
                    )

                _state.value =
                    _state.value.copy(
                        isLoading = false,

                        city = weather.city,
                        country = weather.country,
                        date = DateFormatter.formatDate(
                            weather.date,
                            ),

                        temperature =
                            "${weather.temperature.toInt()}°C",

                        feelsLike =
                            "${weather.feelsLike.toInt()}°C",

                        humidity =
                            "${weather.humidity}%",

                        windSpeed =
                            "${weather.windSpeed} km/h",

                        windDirection =
                            "${weather.windDirection}°",

                        windGust =
                            "${weather.windGust} km/h",

                        uvIndex =
                            weather.uvIndex.toString(),

                        conditionCode =
                            weather.conditionCode,

                        iconUrl =
                            weather.iconUrl,

                        high =
                            "${weather.high.toInt()}°",

                        low =
                            "${weather.low.toInt()}°",

                        sunrise =
                            DateFormatter.formatTime(
                                weather.sunrise
                            ),

                        sunset =
                            DateFormatter.formatTime(
                                weather.sunset
                            ),

                        precipitationProbability =
                            "${weather.precipitationProbability}%",

                        hourly =
                            weather.hourly,

                        daily =
                            weather.daily,

                        error = null
                    )

            } catch (e: Exception) {
                _state.value =

                    _state.value.copy(

                        isLoading = false,

                        error =

                            ErrorHandler.getMessage(e)

                    )

            }
        }
    }
}