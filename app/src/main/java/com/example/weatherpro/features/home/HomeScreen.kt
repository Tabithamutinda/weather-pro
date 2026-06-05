package com.example.weatherpro.features.home

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherpro.core.location.LocationTracker
import com.example.weatherpro.features.home.components.DailyForecastSection
import com.example.weatherpro.features.home.components.HeaderSection
import com.example.weatherpro.features.home.components.HourlyForecastSection
import com.example.weatherpro.features.home.components.WeatherSummaryCard
import com.example.weatherpro.features.location.LocationViewModel
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    locationViewModel: LocationViewModel,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val state by viewModel.state.collectAsState()

    fun loadWeatherFromLocation() {

        scope.launch {

            val location =
                LocationTracker(context)
                    .getCurrentLocation()

            location?.let {

                locationViewModel.updateLocation(
                    latitude = it.first,
                    longitude = it.second
                )

                viewModel.onIntent(
                    HomeIntent.LoadWeather(
                        latitude = it.first,
                        longitude = it.second
                    )
                )
            }
        }
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            contract =
                ActivityResultContracts.RequestPermission()
        ) { granted ->

            if (granted) {

                loadWeatherFromLocation()
            }
        }

    LaunchedEffect(Unit) {

        val hasPermission =
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

        if (hasPermission) {

            loadWeatherFromLocation()

        } else {

            permissionLauncher.launch(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
    }

    when {

        state.isLoading -> {

            Column(

                modifier =

                    Modifier.fillMaxSize(),

                verticalArrangement =

                    Arrangement.Center,

                horizontalAlignment =

                    Alignment.CenterHorizontally

            ) {

                CircularProgressIndicator()

            }

        }

        state.error != null -> {

            Column(

                modifier =

                    Modifier.fillMaxSize(),

                verticalArrangement =

                    Arrangement.Center,

                horizontalAlignment =

                    Alignment.CenterHorizontally

            ) {

                Text(

                    text =

                        state.error ?: "Unknown Error"

                )

            }

        }

        state.temperature.isBlank() -> {

            Column(

                modifier =

                    Modifier.fillMaxSize(),

                verticalArrangement =

                    Arrangement.Center,

                horizontalAlignment =

                    Alignment.CenterHorizontally

            ) {

                CircularProgressIndicator()

                Spacer(

                    modifier =

                        Modifier.height(16.dp)

                )

                Text(

                    text =

                        "Getting your location..."

                )

            }

        }
        else -> {

            AnimatedVisibility(

                visible = true

            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .verticalScroll(
                            rememberScrollState()
                        )
                        .padding(16.dp),
                    verticalArrangement =
                        Arrangement.spacedBy(24.dp)
                ) {

                    HeaderSection(state)

                    WeatherSummaryCard(state)

                    HourlyForecastSection(
                        forecasts = state.hourly
                    )

                    DailyForecastSection(
                        forecasts = state.daily
                    )

                    Spacer(
                        modifier = Modifier.height(100.dp)
                    )
                }
            }
        }
    }
}