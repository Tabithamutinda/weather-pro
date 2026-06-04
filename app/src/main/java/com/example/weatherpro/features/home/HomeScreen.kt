package com.example.weatherpro.features.home

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherpro.core.location.LocationTracker
import com.example.weatherpro.features.home.components.DailyForecastSection
import com.example.weatherpro.features.home.components.HeaderSection
import com.example.weatherpro.features.home.components.HourlyForecastSection
import com.example.weatherpro.features.home.components.WeatherSummaryCard
import com.example.weatherpro.features.weather.WeatherViewModel

@Composable
fun HomeScreen(
    weatherViewModel: WeatherViewModel
) {


    val context = LocalContext.current

    val uiState by weatherViewModel.uiState.collectAsState()

    val permissionLauncher =
        rememberLauncherForActivityResult(
            contract =
                ActivityResultContracts.RequestPermission()
        ) { granted ->

            if (granted) {

                // We'll fetch location below
            }
        }

    LaunchedEffect(Unit) {

        permissionLauncher.launch(
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    }

    LaunchedEffect(uiState.latitude) {

        if (
            uiState.latitude == null &&
            uiState.longitude == null
        ) {

            val location =
                LocationTracker(context)
                    .getCurrentLocation()

            location?.let {

                weatherViewModel.loadWeather(
                    latitude = it.first,
                    longitude = it.second
                )
            }
        }
    }

    when {

        uiState.isLoading -> {

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

        uiState.error != null -> {

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
                        uiState.error ?: "Unknown Error"
                )
            }
        }

        else -> {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(16.dp),
                verticalArrangement =
                    Arrangement.spacedBy(24.dp)
            ) {

                HeaderSection(uiState)

                WeatherSummaryCard(uiState)

                HourlyForecastSection(
                    forecasts = uiState.hourly
                )

                DailyForecastSection(
                    forecasts = uiState.daily
                )

                Spacer(
                    modifier = Modifier.height(100.dp)
                )
            }
        }
    }
}