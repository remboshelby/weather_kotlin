package com.example.common.network.api

import com.example.common.network.models.daily_forecast.DailyResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
//16day forecast
    @GET("/daily")
    fun fecthDailyWeather (@Query("id") id :Int,
                           @Query("appid") appid : String) : Observable<DailyResponse>
}