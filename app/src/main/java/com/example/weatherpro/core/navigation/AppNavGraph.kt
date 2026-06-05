package com.example.weatherpro.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherpro.features.forecast.ForecastScreen
import com.example.weatherpro.features.home.HomeScreen
import com.example.weatherpro.features.splash.SplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherpro.features.location.LocationViewModel

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()
    val locationViewModel: LocationViewModel =

        hiltViewModel()

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

            ) { padding ->

                HomeScreen(

                    modifier = Modifier.padding(padding),
                    locationViewModel = locationViewModel
                )

            }

        }

        composable(Screen.Forecast.route) {
            WeatherScaffold(

                navController = navController

            ) { padding ->

                ForecastScreen(

                    modifier = Modifier.padding(padding),
                    locationViewModel = locationViewModel

                )

            }

        }
    }
}