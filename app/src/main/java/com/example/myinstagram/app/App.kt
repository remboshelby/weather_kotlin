package com.example.myinstagram.app

import android.app.Application
import com.example.common.di.CommonApplication
import com.example.common.di.CommonComponent
import com.example.myinstagram.R
import com.example.myinstagram.app.di.ApplicationComponent
import com.example.myinstagram.app.di.DaggerApplicationComponent

class App : Application(), CommonApplication {
    private lateinit var applicationComponent : ApplicationComponent;


    override fun onCreate() {
        super.onCreate()

        makeComponent()
    }

    private fun makeComponent() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .context(this)
            .serverUrl(getString(R.string.server_url))
            .build();
    }

    override fun component(): CommonComponent {
        return applicationComponent;
    }
}
