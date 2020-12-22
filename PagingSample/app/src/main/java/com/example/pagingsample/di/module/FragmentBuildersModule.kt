package com.example.pagingsample.di.module

import com.example.pagingsample.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun bindSearchFragment(): SearchFragment
}