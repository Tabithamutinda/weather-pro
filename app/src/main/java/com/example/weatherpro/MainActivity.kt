package com.example.weatherpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weatherpro.core.navigation.AppNavGraph
import com.example.weatherpro.ui.theme.WeatherProTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        setContent {

            WeatherProTheme {

                AppNavGraph()
            }
        }
    }
}