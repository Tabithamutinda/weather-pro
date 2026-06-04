package com.example.weatherpro.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherpro.features.current.CurrentScreen
import com.example.weatherpro.features.daily.DailyScreen
import com.example.weatherpro.features.home.HomeScreen
import com.example.weatherpro.features.hourly.HourlyScreen
import com.example.weatherpro.features.splash.SplashScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(Screen.Splash.route) {

            SplashScreen(
                onNavigateToHome = {
                    navController.navigate(
                        Screen.Home.route
                    ) {
                        popUpTo(
                            Screen.Splash.route
                        ) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Home.route) {

            WeatherScaffold(
                navController = navController
            ) {
                HomeScreen()
            }
        }

        composable(Screen.Current.route) {

            WeatherScaffold(
                navController = navController
            ) {
                CurrentScreen()
            }
        }

        composable(Screen.Hourly.route) {

            WeatherScaffold(
                navController = navController
            ) {
                HourlyScreen()
            }
        }

        composable(Screen.Daily.route) {

            WeatherScaffold(
                navController = navController
            ) {
                DailyScreen()
            }
        }
    }
}