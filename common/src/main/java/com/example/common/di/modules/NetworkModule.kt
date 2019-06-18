package com.example.common.di.modules

import android.content.Context
import com.example.common.di.ServerUrl
import com.example.common.network.api.WeatherApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module class NetworkModule {
    @Provides
    @Singleton
    fun provideGson() : Gson{
        return GsonBuilder().setLenient().create()
    }
    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder().build()
    }
    @Provides
    @Singleton
    fun provideRetrofit(@ServerUrl baseUrl :String, okHttpClient: OkHttpClient ) : Retrofit{
        var gson = GsonBuilder()
            .setLenient()
            .create();
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    }
    @Provides
    @Singleton
    fun weatherApi(retrofit: Retrofit) :WeatherApi{
        return retrofit.create<WeatherApi>(WeatherApi::class.java)
    }

}