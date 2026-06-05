package com.example.weatherpro.app.di

import com.example.weatherpro.data.repository.ForecastRepositoryImpl
import com.example.weatherpro.data.repository.WeatherRepositoryImpl
import com.example.weatherpro.domain.repository.ForecastRepository
import com.example.weatherpro.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        repository: WeatherRepositoryImpl
    ): WeatherRepository

    @Binds
    @Singleton
    abstract fun bindForecastRepository(
        repository: ForecastRepositoryImpl
    ): ForecastRepository
}