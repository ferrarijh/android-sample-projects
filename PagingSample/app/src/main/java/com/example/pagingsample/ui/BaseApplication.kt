package com.example.pagingsample.ui

import com.example.pagingsample.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}