package com.example.weatherpro.features.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherpro.core.network.NetworkModule
import com.example.weatherpro.data.repository.WeatherRepositoryImpl
import com.example.weatherpro.domain.usecase.GetWeatherUseCase
import com.example.weatherpro.features.home.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val repository =
        WeatherRepositoryImpl(
            NetworkModule.weatherApi
        )

    private val getWeatherUseCase =
        GetWeatherUseCase(repository)

    private val _uiState =
        MutableStateFlow(HomeUiState())

    val uiState: StateFlow<HomeUiState> =
        _uiState.asStateFlow()

    fun loadWeather(
        latitude: Double,
        longitude: Double
    ) {

        if (
            _uiState.value.hourly.isNotEmpty() &&
            _uiState.value.daily.isNotEmpty()
        ) return

        viewModelScope.launch {

            try {

                _uiState.value =
                    _uiState.value.copy(
                        isLoading = true
                    )

                val weather =
                    getWeatherUseCase(
                        lat = latitude,
                        lon = longitude
                    )

                _uiState.value =
                    HomeUiState(
                        isLoading = false,

                        city = weather.city,
                        country = weather.country,

                        date = weather.date,
                        timezone = weather.timezone,

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
                            weather.sunrise,

                        sunset =
                            weather.sunset,

                        precipitationProbability =
                            "${weather.precipitationProbability}%",

                        hourly =
                            weather.hourly,

                        daily =
                            weather.daily,

                        latitude =
                            latitude,

                        longitude =
                            longitude
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(
                        isLoading = false,
                        error =
                            e.message
                    )
            }
        }
    }
}