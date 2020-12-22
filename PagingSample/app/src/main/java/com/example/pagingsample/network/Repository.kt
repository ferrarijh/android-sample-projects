package com.example.pagingsample.network

import androidx.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    val pixabayAPI: PixabayAPI
) {
    fun getImages(q: String){

    }
}