package com.example.weatherpro.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val WeatherColorScheme = darkColorScheme(
    primary = WeatherAccent,
    secondary = WeatherAccent,
    tertiary = WeatherAccent,

    background = WeatherBackground,
    surface = WeatherCard,

    onPrimary = WeatherBackground,
    onSecondary = WeatherBackground,
    onTertiary = WeatherBackground,

    onBackground = WeatherTextPrimary,
    onSurface = WeatherTextPrimary
)

@Composable
fun WeatherProTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = WeatherColorScheme,
        typography = Typography,
        content = content
    )
}