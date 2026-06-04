package com.example.weatherpro.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private data class DailyForecastItem(
    val day: String,
    val highLow: String
)

@Composable
fun DailyForecastSection() {

    val forecasts = listOf(
        DailyForecastItem("Friday", "29° / 18°"),
        DailyForecastItem("Saturday", "31° / 19°"),
        DailyForecastItem("Sunday", "28° / 17°"),
        DailyForecastItem("Monday", "30° / 20°"),
        DailyForecastItem("Tuesday", "27° / 16°")
    )

    Column {

        Text(
            text = "7 Day Forecast",
                    style =

                    MaterialTheme.typography.titleLarge
        )

        forecasts.forEach { forecast ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(

                    containerColor =

                        MaterialTheme.colorScheme.surface

                ),
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement =
                        Arrangement.SpaceBetween
                ) {

                    Row {

                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = null
                        )

                        Text(
                            text = forecast.day,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    Text(
                        text = forecast.highLow
                    )
                }
            }
        }
    }
}