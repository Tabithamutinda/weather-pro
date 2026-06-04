package com.example.weatherpro.features.home

data class HomeUiState(

    val city: String = "Nairobi",

    val date: String = "Thursday, June 5",

    val temperature: String = "27°",

    val condition: String = "Partly Cloudy",

    val humidity: String = "62%",

    val windSpeed: String = "12 km/h",

    val high: String = "29°",

    val low: String = "18°"

)