package com.example.pagingsample.di.module

import com.example.pagingsample.network.PixabayAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PixabayApiModule {
    companion object{
        @JvmStatic
        @Provides
        fun providePixabayAPI(retrofit: Retrofit): PixabayAPI{
            return retrofit.create(PixabayAPI::class.java)
        }
    }
}