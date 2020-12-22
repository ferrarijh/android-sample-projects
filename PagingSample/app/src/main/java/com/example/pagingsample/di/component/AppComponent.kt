package com.example.pagingsample.di.component

import android.app.Application
import com.example.pagingsample.di.module.ActivityBuilderModule
import com.example.pagingsample.di.module.AppModule
import com.example.pagingsample.di.module.ViewModelModule
import com.example.pagingsample.di.module.ViewModelProviderFactoryModule
import com.example.pagingsample.ui.BaseApplication
import com.example.pagingsample.ui.ViewModelProviderFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules=[
    AndroidInjectionModule::class,
    ActivityBuilderModule::class,
    AppModule::class,
    ViewModelProviderFactoryModule::class
])
interface AppComponent: AndroidInjector<BaseApplication> {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app: Application): AppComponent
    }
}