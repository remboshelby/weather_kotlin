package com.example.common.di

import com.example.common.network.repository.WeatherRepository

interface CommonComponent {
    fun weatherRepository() : WeatherRepository
}