package com.example.pagingsample.di.module

import com.example.pagingsample.network.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class AppModule {
    companion object {
        const val BASE_URL = "https://pixabay.com/"

        @JvmStatic
        @Provides
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }
    }

    @Binds
    abstract fun bindRepository(repo: Repository): Repository
}