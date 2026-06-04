package com.example.weatherpro.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.weatherpro.core.ui.components.WeatherBottomBar

@Composable
fun WeatherScaffold(
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit
) {

    val backStack =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        backStack.value?.destination?.route ?: ""

    Scaffold(

        contentWindowInsets =
            WindowInsets.safeDrawing,

        bottomBar = {

            WeatherBottomBar(
                currentRoute = currentRoute,
                onNavigate = { route ->

                    navController.navigate(route) {

                        launchSingleTop = true

                        restoreState = true

                        popUpTo(
                            navController.graph.startDestinationId
                        ) {
                            saveState = true
                        }
                    }
                }
            )
        }
    ) { padding ->

        content(padding)
    }
}