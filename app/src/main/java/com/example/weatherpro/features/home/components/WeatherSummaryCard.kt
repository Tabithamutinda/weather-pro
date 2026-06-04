package com.example.weatherpro.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherpro.features.home.HomeUiState

@Composable
fun WeatherSummaryCard(
    state: HomeUiState
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(

            containerColor =

                MaterialTheme.colorScheme.surface

        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Today's Forecast",
                style = MaterialTheme.typography.titleMedium
            )

            SummaryRow(
                "High",
                state.high
            )

            SummaryRow(
                "Low",
                state.low
            )

            SummaryRow(
                "Wind",
                state.windSpeed
            )

            SummaryRow(
                "Humidity",
                state.humidity
            )
        }
    }
}

@Composable
private fun SummaryRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Text(label)

        Text(value)
    }
}