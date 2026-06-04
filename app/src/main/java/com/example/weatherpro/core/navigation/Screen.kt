package com.example.weatherpro.core.navigation

sealed class Screen(val route: String) {

    data object Splash : Screen("splash")

    data object Home : Screen("home")

    data object Current : Screen("current")

    data object Hourly : Screen("hourly")

    data object Daily : Screen("daily")

}