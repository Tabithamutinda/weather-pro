package com.example.weatherpro.core.util

import java.text.SimpleDateFormat
import java.util.Locale

object DateFormatter {

    fun formatDate(
        date: String
    ): String {

        return try {

            val input =
                SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm",
                    Locale.getDefault()
                )

            val output =
                SimpleDateFormat(
                    "EEE, dd MMM yyyy",
                    Locale.getDefault()
                )

            val parsed =
                input.parse(date)

            output.format(parsed!!)

        } catch (e: Exception) {

            date
        }
    }

    fun formatTime(
        date: String
    ): String {

        return try {

            val input =
                SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm",
                    Locale.getDefault()
                )

            val output =
                SimpleDateFormat(
                    "h:mm a",
                    Locale.getDefault()
                )

            val parsed =
                input.parse(date)

            output.format(parsed!!)

        } catch (e: Exception) {

            date
        }
    }
}