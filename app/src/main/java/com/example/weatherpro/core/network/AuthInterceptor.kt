package com.example.weatherpro.core.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(
        chain: Interceptor.Chain
    ): Response {

        val request =
            chain.request()
                .newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer wai_e9abb6.f4b04f48ea2e68d7ce2d3875910508c45827e04fa389d72e"
                )
                .build()

        return chain.proceed(request)
    }
}