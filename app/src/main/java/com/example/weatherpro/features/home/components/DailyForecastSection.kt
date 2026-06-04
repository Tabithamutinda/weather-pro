package com.example.weatherpro.features.home.components

import androidx.compose.foundation.layout.*
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
import com.example.weatherpro.domain.model.DailyWeather
import com.example.weatherpro.ui.theme.WeatherTextPrimary

private fun formatDay(
    date: String
): String {

    val parts = date.split("-")

    if (parts.size != 3) return date

    val year = parts[0].toInt()
    val month = parts[1].toInt() - 1
    val day = parts[2].toInt()

    val calendar = java.util.Calendar.getInstance()

    calendar.set(year, month, day)

    return when (
        calendar.get(
            java.util.Calendar.DAY_OF_WEEK
        )
    ) {
        java.util.Calendar.MONDAY -> "Mon"
        java.util.Calendar.TUESDAY -> "Tue"
        java.util.Calendar.WEDNESDAY -> "Wed"
        java.util.Calendar.THURSDAY -> "Thu"
        java.util.Calendar.FRIDAY -> "Fri"
        java.util.Calendar.SATURDAY -> "Sat"
        java.util.Calendar.SUNDAY -> "Sun"
        else -> date
    }
}
@Composable
fun DailyForecastSection(
    forecasts: List<DailyWeather>
) {

    Column {

        Text(
            text = "Forecast",
            style =
                MaterialTheme.typography.titleMedium
        )

        forecasts.forEach { forecast ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.surface.copy(
                            alpha = 0.9f
                        )
                )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = formatDay(forecast.date),
                        modifier = Modifier.weight(2f)
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
                    Spacer(

                        modifier = Modifier.weight(1f)

                    )
                    Text(
                        text =
                            "${forecast.maxTemperature.toInt()}° / ${forecast.minTemperature.toInt()}°",
                        modifier = Modifier.weight(2f)
                    )
                }
            }
        }
    }
}