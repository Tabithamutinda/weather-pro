package com.example.weatherpro.features.forecast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherpro.features.forecast.components.HourlyForecastCard
import com.example.weatherpro.features.location.LocationViewModel

@Composable
fun ForecastScreen(
    modifier: Modifier = Modifier,
    locationViewModel: LocationViewModel,
    viewModel: ForecastViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    val locationState by
    locationViewModel.uiState.collectAsState()

    LaunchedEffect(
        locationState.latitude,
        locationState.longitude
    ) {

        val lat =
            locationState.latitude

        val lon =
            locationState.longitude

        if (
            lat != null &&
            lon != null
        ) {

            viewModel.onIntent(
                ForecastContract.Intent.LoadForecast(
                    latitude = lat,
                    longitude = lon
                )
            )
        }
    }

    when {

        state.isLoading -> {

            Column(
                modifier =
                    Modifier.fillMaxSize(),
                horizontalAlignment =
                    Alignment.CenterHorizontally,
                verticalArrangement =
                    Arrangement.Center
            ) {

                CircularProgressIndicator()
            }
        }

        state.error != null -> {

            Column(
                modifier =
                    Modifier.fillMaxSize(),
                horizontalAlignment =
                    Alignment.CenterHorizontally,
                verticalArrangement =
                    Arrangement.Center
            ) {

                Text(
                    text =
                        state.error
                            ?: "Unknown Error"
                )
            }
        }

        state.hourly.isEmpty() -> {

            Column(
                modifier =
                    Modifier.fillMaxSize(),
                horizontalAlignment =
                    Alignment.CenterHorizontally,
                verticalArrangement =
                    Arrangement.Center
            ) {

                CircularProgressIndicator()

                Text(
                    text =
                        "Loading forecast..."
                )
            }
        }

        else -> {

            LazyColumn(
                modifier =
                    modifier.fillMaxSize(),
                contentPadding =
                    PaddingValues(
                        top = 24.dp,
                        bottom = 120.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                verticalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {

                items(
                    state.hourly
                ) { hourly ->

                    HourlyForecastCard(
                        forecast = hourly
                    )
                }
            }
        }
    }
}