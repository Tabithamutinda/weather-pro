package com.example.weatherpro.core.util

fun getConditionText(
    code: String
): String {

    return when (code) {

        "0" -> "Clear Sky"

        "1" -> "Mainly Clear"

        "2" -> "Partly Cloudy"

        "3" -> "Overcast"

        "51" -> "Light Drizzle"

        else -> "Unknown"
    }
}