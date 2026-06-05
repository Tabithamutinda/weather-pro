package com.example.weatherpro.core.util

import retrofit2.HttpException

object ErrorHandler {

    fun getMessage(
        throwable: Throwable
    ): String {

        return when (throwable) {

            is HttpException -> {

                when (throwable.code()) {

                    400 -> "Invalid request"

                    401 -> "Invalid API key"

                    403 -> "Access denied"

                    404 -> "Weather data not found"

                    429 -> "Too many requests. Try again later"

                    500 -> "Server unavailable"

                    else ->
                        "Server error (${throwable.code()})"
                }
            }

            else -> {

                throwable.message
                    ?: "Something went wrong"
            }
        }
    }
}