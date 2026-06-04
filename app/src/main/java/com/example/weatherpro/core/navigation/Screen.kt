package com.example.weatherpro.core.navigation

sealed class Screen(val route: String) {

    data object Splash : Screen("splash")

    data object Home : Screen("home")

    data object Forecast : Screen("forecast")
}