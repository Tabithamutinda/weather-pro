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
        Screen.Current.route,
        "Current",
        Icons.Outlined.Thermostat
    )

    data object Hourly : BottomNavItem(
        Screen.Hourly.route,
        "Hourly",
        Icons.Outlined.Schedule
    )

    data object Daily : BottomNavItem(
        Screen.Daily.route,
        "Daily",
        Icons.Outlined.CalendarMonth
    )
}