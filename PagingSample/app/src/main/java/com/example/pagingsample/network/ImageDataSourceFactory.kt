package com.example.pagingsample.network

import android.util.Log
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
    companion object{
        const val TAG = "ImageDataSourceFactory"
    }

    var query: String = ""
//    val liveImageDataSource = MutableLiveData<PageKeyedDataSource<Int, Image>>()

    override fun create(): DataSource<Int, Image> {
        val newSource = ImageDataSource(compositeDisposable, pixabayAPI, query)
//        liveImageDataSource.value = newSource
        Log.d(TAG, "new DataSource created: $newSource")
        return newSource
    }

    fun dispose(){
//        compositeDisposable.dispose()
    }
}