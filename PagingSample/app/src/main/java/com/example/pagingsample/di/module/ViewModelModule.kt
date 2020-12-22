package com.example.pagingsample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import com.example.pagingsample.di.annotation.ViewModelKey
import com.example.pagingsample.network.ImageDataSource
import com.example.pagingsample.ui.MainViewModel
import com.example.pagingsample.ui.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {
    companion object{
        @Provides
        fun providePagedListConfig(): PagedList.Config{
            return PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(ImageDataSource.PAGE_SIZE)
                .build()
        }
    }

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(vm: MainViewModel): ViewModel
}