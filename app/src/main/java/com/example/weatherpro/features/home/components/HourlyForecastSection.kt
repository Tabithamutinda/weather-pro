package com.example.weatherpro.features.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
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


@Composable
fun HourlyForecastSection(
    forecasts: List<HourlyWeather>
) {

    Column {

        Text(
            text = "Hourly Forecast",
            style = MaterialTheme.typography.titleMedium
        )

        LazyRow(
            horizontalArrangement =
                Arrangement.spacedBy(12.dp),
            contentPadding =
                PaddingValues(vertical = 12.dp)
        ) {

            items(
                forecasts.take(12)
            ) { forecast ->

                Card(
                    modifier = Modifier
                        .width(100.dp)
                        .height(150.dp),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            MaterialTheme.colorScheme.surface.copy(
                                alpha = 0.9f
                            )
                    )
                ) {

                    Column(
                        horizontalAlignment =
                            Alignment.CenterHorizontally,
                        verticalArrangement =
                            Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxSize()
                    ) {

                        Text(
                            forecast.time.takeLast(5)
                        )
                        val context = LocalContext.current

                        val imageLoader = ImageLoader.Builder(context)
                            .components {
                                add(SvgDecoder.Factory())
                            }
                            .build()

                        AsyncImage(
                            model = forecast.iconUrl,
                            imageLoader = imageLoader,
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            colorFilter = ColorFilter.tint(
                                WeatherTextPrimary
                            )
                        )

                        Text(
                            text =
                                "${forecast.temperature.toInt()}°C"
                        )
                    }
                }
            }
        }
    }
}