package com.example.weather.di

import com.example.common.di.CommonComponent
import com.example.weather.fragment.WeatherMainFragment
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = arrayOf(CommonComponent::class), modules = arrayOf(WeatherModule::class))
interface WeatherComponent  {
    @Component.Builder
    interface Builder{
        @BindsInstance
        abstract fun root(weatherMainFragment: WeatherMainFragment): Builder

        abstract fun commonComponent(commonComponent: CommonComponent): Builder

        abstract fun build(): WeatherComponent
    }
}