package com.example.weatherpro.core.util

import retrofit2.HttpException

object ErrorHandler {

    fun getMessage(
        throwable: Throwable
    ): String {

        return when (throwable) {

            is HttpException -> {

                when (throwable.code()) {

                    400 -> "Bad Request"

                    401 -> "Unauthorized"

                    403 -> "Forbidden"

                    429 -> "Too Many Requests"

                    500 -> "Internal Error"

                    503 -> "Service Unavailable"

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