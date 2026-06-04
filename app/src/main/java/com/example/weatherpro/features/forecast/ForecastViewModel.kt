package com.example.weatherpro.features.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherpro.core.network.NetworkModule
import com.example.weatherpro.data.repository.WeatherRepositoryImpl
import com.example.weatherpro.domain.usecase.GetForecastUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ForecastViewModel : ViewModel() {

    private val repository =
        WeatherRepositoryImpl(
            NetworkModule.weatherApi
        )

    private val getForecastUseCase =
        GetForecastUseCase(repository)

    private val _uiState =
        MutableStateFlow(ForecastUiState())

    val uiState: StateFlow<ForecastUiState> =
        _uiState.asStateFlow()

    fun loadForecast(
        latitude: Double,
        longitude: Double
    ) {

        viewModelScope.launch {

            try {

                _uiState.value =
                    _uiState.value.copy(
                        isLoading = true,
                        error = null
                    )

                val forecast =
                    getForecastUseCase(
                        lat = latitude,
                        lon = longitude
                    )

                _uiState.value =
                    ForecastUiState(
                        hourly = forecast.hourly
                    )

            } catch (e: Exception) {

                _uiState.value =
                    ForecastUiState(
                        error =
                            e.message
                                ?: "Unable to load forecast"
                    )
            }
        }
    }
}