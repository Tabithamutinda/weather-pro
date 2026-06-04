package com.example.weatherpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.weatherpro.core.navigation.AppNavGraph
import com.example.weatherpro.ui.theme.WeatherProTheme
import com.example.weatherpro.features.weather.WeatherViewModel

class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherProTheme {
                AppNavGraph(

                    weatherViewModel =

                        weatherViewModel

                )
            }

        }
    }
}