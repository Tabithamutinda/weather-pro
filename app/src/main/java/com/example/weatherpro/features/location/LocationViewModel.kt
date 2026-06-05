package com.example.weatherpro.features.location

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class LocationUiState(
    val latitude: Double? = null,
    val longitude: Double? = null
)

@HiltViewModel
class LocationViewModel @Inject constructor() : ViewModel() {

    private val _uiState =
        MutableStateFlow(LocationUiState())

    val uiState =
        _uiState.asStateFlow()

    fun updateLocation(
        latitude: Double,
        longitude: Double
    ) {
        _uiState.value =
            LocationUiState(
                latitude = latitude,
                longitude = longitude
            )
    }
}