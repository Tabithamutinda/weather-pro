package com.example.weatherpro.domain.usecase

import com.example.weatherpro.domain.model.Weather
import com.example.weatherpro.domain.repository.ForecastRepository
import javax.inject.Inject


class GetForecastUseCase @Inject constructor(

    private val repository: ForecastRepository

) {

    suspend operator fun invoke(
        lat: Double,
        lon: Double
    ): Weather {

        return repository.getForecast(
            lat,
            lon
        )
    }
}
