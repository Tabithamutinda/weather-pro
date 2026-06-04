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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherpro.features.forecast.components.HourlyForecastCard
import com.example.weatherpro.features.weather.WeatherViewModel

@Composable
fun ForecastScreen(
    modifier: Modifier = Modifier,
    weatherViewModel: WeatherViewModel
) {

    val state by
    weatherViewModel.uiState.collectAsState()

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
                horizontalAlignment =
                    Alignment.CenterHorizontally,
                verticalArrangement =
                    Arrangement.Center
            ) {

                Text(
                    text =
                        state.error!!
                )
            }
        }

        else -> {

            LazyColumn(
                modifier =
                    Modifier.fillMaxSize(),
                contentPadding = PaddingValues(

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