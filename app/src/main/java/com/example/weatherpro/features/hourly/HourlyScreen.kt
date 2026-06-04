package com.example.weatherpro.features.hourly

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable

fun HourlyScreen() {

    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center

    ) {
        Text(
            text = "Hourly Screen"
        )
    }
}