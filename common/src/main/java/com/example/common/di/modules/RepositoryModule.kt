package com.example.common.di.modules

import com.example.common.network.api.WeatherApi
import com.example.common.network.repository.WeatherRepository
import dagger.Module
import dagger.Provides

@Module class RepositoryModule {
    @Provides
    fun weatherRepository (weatherApi: WeatherApi) : WeatherRepository{
        return WeatherRepository(weatherApi)
    }
}