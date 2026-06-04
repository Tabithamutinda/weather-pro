package com.example.weatherpro.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherpro.features.forecast.ForecastScreen
import com.example.weatherpro.features.home.HomeScreen
import com.example.weatherpro.features.splash.SplashScreen
import com.example.weatherpro.features.weather.WeatherViewModel

@Composable
fun AppNavGraph(weatherViewModel: WeatherViewModel) {

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
                HomeScreen(
                    weatherViewModel =
                        weatherViewModel
                )
            }
        }

        composable(Screen.Forecast.route) {

            WeatherScaffold(
                navController = navController
            ) {
                ForecastScreen(
                    weatherViewModel =
                        weatherViewModel
                )
            }
        }
    }
}