package com.example.pagingsample.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Module
abstract class CompositeDisposableModule {
    companion object{
        @JvmStatic
        @Provides
        fun provideCompositeDisposable() = CompositeDisposable()
    }
}