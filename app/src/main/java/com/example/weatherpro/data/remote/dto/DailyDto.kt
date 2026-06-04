package com.example.weatherpro.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DailyDto(

    val date: String,

    @SerializedName("temp_min")
    val tempMin: Double,

    @SerializedName("temp_max")
    val tempMax: Double,

    @SerializedName("precipitation_sum")
    val precipitationSum: Double,

    val sunrise: String,

    val sunset: String,

    @SerializedName("condition_code")
    val conditionCode: String,

    val icon: String,

    @SerializedName("precipitation_probability")
    val precipitationProbability: Int,

    @SerializedName("wind_max")
    val windMax: Double,

    @SerializedName("icon_path")
    val iconPath: String
)