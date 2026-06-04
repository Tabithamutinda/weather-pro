package com.example.weatherpro.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private data class HourlyForecastItem(
    val time: String,
    val temperature: String
)

@Composable
fun HourlyForecastSection() {

    val forecasts = listOf(
        HourlyForecastItem("10 AM", "26°"),
        HourlyForecastItem("11 AM", "27°"),
        HourlyForecastItem("12 PM", "28°"),
        HourlyForecastItem("1 PM", "29°"),
        HourlyForecastItem("2 PM", "29°")
    )

    Column {

        Text(
            text = "Hourly Forecast",
            style = MaterialTheme.typography.titleMedium
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {

            items(forecasts) { forecast ->

                Card(
                    modifier = Modifier
                        .width(100.dp)

                        .height(130.dp),
                            colors = CardDefaults.cardColors(

                            containerColor =

                                MaterialTheme.colorScheme.surface

                            ),
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .width(90.dp)
                    ) {

                        Text(forecast.time)

                        Icon(

                            imageVector = Icons.Default.WbSunny,

                            contentDescription = null,

                            tint = MaterialTheme.colorScheme.primary

                        )

                        Text(

                            text = forecast.temperature,

                            style =

                                MaterialTheme.typography.titleMedium

                        )
                    }
                }
            }
        }
    }
}