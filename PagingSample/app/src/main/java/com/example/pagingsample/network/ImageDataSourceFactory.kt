package com.example.pagingsample.network

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.pagingsample.model.Image
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class ImageDataSourceFactory @Inject constructor(
    val compositeDisposable: CompositeDisposable,
    val pixabayAPI: PixabayAPI
): DataSource.Factory<Int, Image>() {
    var query: String = ""
//    val liveImageDataSource = MutableLiveData<PageKeyedDataSource<Int, Image>>()

    override fun create(): DataSource<Int, Image> {
        val newSource = ImageDataSource(compositeDisposable, pixabayAPI, query)
//        liveImageDataSource.value = newSource
        return newSource
    }
}