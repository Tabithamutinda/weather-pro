package com.example.weatherpro.features.forecast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherpro.core.util.ErrorHandler
import com.example.weatherpro.domain.usecase.GetForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(

    private val getForecastUseCase: GetForecastUseCase

) : ViewModel() {

    private val _state =
        MutableStateFlow(
            ForecastContract.State()
        )

    val state =
        _state.asStateFlow()

    fun onIntent(
        intent: ForecastContract.Intent
    ) {

        when (intent) {

            is ForecastContract.Intent.LoadForecast -> {

                loadForecast(
                    latitude = intent.latitude,
                    longitude = intent.longitude
                )
            }
        }
    }

    private fun loadForecast(
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

                val forecast =
                    getForecastUseCase(
                        lat = latitude,
                        lon = longitude
                    )

                _state.value =
                    _state.value.copy(
                        isLoading = false,
                        hourly = forecast.hourly,
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