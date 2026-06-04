package com.example.weatherpro.data.remote.dto

import com.google.gson.annotations.SerializedName

data class HourlyDto(

    val time: String,

    val temperature: Double,

    @SerializedName("precipitation_probability")
    val precipitationProbability: Int,

    @SerializedName("wind_speed")
    val windSpeed: Double,

    @SerializedName("condition_code")
    val conditionCode: String,

    val icon: String,

    val humidity: Int,

    @SerializedName("feels_like")
    val feelsLike: Double,

    @SerializedName("wind_gust")
    val windGust: Double,

    @SerializedName("uv_index")
    val uvIndex: Double,

    @SerializedName("icon_path")
    val iconPath: String
)