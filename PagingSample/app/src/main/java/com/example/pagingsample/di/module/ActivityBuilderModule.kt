package com.example.pagingsample.di.module

import com.example.pagingsample.di.annotation.MainScope
import com.example.pagingsample.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @MainScope
    @ContributesAndroidInjector(modules=[PixabayApiModule::class,
        CompositeDisposableModule::class,
        FragmentBuildersModule::class,
        ViewModelModule::class
    ])
    abstract fun contributeMainActivity(): MainActivity
}