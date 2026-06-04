package com.example.weatherpro.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Thermostat
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    data object Home : BottomNavItem(
        Screen.Home.route,
        "Home",
        Icons.Outlined.Home
    )

    data object Current : BottomNavItem(
        Screen.Forecast.route,
        "Forecast",
        Icons.Outlined.Thermostat
    )
}