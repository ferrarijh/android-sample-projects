package com.example.pagingsample.network

import com.example.pagingsample.model.PixabayResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {
    @GET("api")
    fun getImages(
        @Query("q") keyword: String,
        @Query("key") apiKey: String = Key.API_KEY,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20
    ): Flowable<PixabayResponse>
}