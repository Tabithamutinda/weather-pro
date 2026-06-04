package com.example.weatherpro.features.forecast.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import com.example.weatherpro.domain.model.HourlyWeather
import com.example.weatherpro.ui.theme.WeatherTextPrimary

private fun formatHour(
    dateTime: String
): String {

    return try {

        dateTime
            .substringAfter("T")
            .substring(0, 5)

    } catch (e: Exception) {

        dateTime
    }
}

@Composable
fun HourlyForecastCard(
    forecast: HourlyWeather
) {

    val context = LocalContext.current

    val imageLoader =
        ImageLoader.Builder(context)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()

    Card(
        modifier =
            Modifier.fillMaxWidth(),
        colors =
            CardDefaults.cardColors(
                containerColor =
                    MaterialTheme
                        .colorScheme
                        .surface
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement =
                Arrangement.SpaceBetween,
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Column {

                Text(
                    text =
                        formatHour(
                            forecast.time
                        ),
                    style =
                        MaterialTheme
                            .typography
                            .titleMedium
                )
            }

            AsyncImage(
                model =
                    forecast.iconUrl,
                imageLoader =
                    imageLoader,
                contentDescription = null,
                modifier =
                    Modifier.size(50.dp),
                colorFilter =
                    ColorFilter.tint(
                        WeatherTextPrimary
                    )
            )

            Column(
                horizontalAlignment =
                    Alignment.End
            ) {

                Text(
                    text =
                        "${forecast.temperature.toInt()}°"
                )

                Text(
                    text =
                        "${forecast.windSpeed.toInt()} km/h"
                )
            }
        }
    }
}