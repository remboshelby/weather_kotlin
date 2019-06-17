package com.example.myinstagram.app.di

import android.app.Application
import android.content.Context
import com.example.common.di.CommonComponent
import com.example.common.di.modules.NetworkModule
import com.example.common.di.modules.RepositoryModule
import com.example.common.di.modules.SharedPreferenceModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = arrayOf(RepositoryModule::class, NetworkModule::class, SharedPreferenceModule::class))
interface ApplicationComponent : CommonComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context (context: Context) : Builder

        fun build() :ApplicationComponent
    }
}