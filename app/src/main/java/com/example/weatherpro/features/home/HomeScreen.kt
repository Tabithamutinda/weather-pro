package com.example.weatherpro.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherpro.features.home.components.DailyForecastSection
import com.example.weatherpro.features.home.components.HeaderSection
import com.example.weatherpro.features.home.components.HourlyForecastSection
import com.example.weatherpro.features.home.components.WeatherSummaryCard

@Composable
fun HomeScreen() {

    val state = HomeUiState()

    Column(
        modifier = Modifier

            .fillMaxSize()

            .background(

                MaterialTheme.colorScheme.background

            )

            .verticalScroll(

                rememberScrollState()

            )

            .padding(16.dp),
        verticalArrangement =
            Arrangement.spacedBy(24.dp)
    ) {

        HeaderSection(state)

        WeatherSummaryCard(state)

        HourlyForecastSection()

        DailyForecastSection()

        Spacer(
            modifier = Modifier.height(80.dp)
        )
    }
}