package com.example.pagingsample.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.pagingsample.ui.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderFactoryModule {
    @Binds
    abstract fun bindViewModelProviderFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}