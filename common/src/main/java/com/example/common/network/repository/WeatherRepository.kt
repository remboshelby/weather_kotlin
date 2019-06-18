package com.example.common.network.repository

import com.example.common.network.api.WeatherApi
import com.example.common.network.models.daily_forecast.DailyResponse
import io.reactivex.Observable

class WeatherRepository (weatherApi: WeatherApi) {
    val weatherApi = weatherApi
    fun fecthDailyWeather(id : Int, appid : String) : Observable<DailyResponse>{
        return weatherApi.fecthDailyWeather(id, appid);
    }
}