package com.example.pagingsample.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.pagingsample.model.Image
import com.example.pagingsample.model.PixabayResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subscribers.ResourceSubscriber
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

//TODO("Int?")
class ImageDataSource(
    val compositeDisposable: CompositeDisposable,
    val pixabayAPI: PixabayAPI,
    val query: String
): PageKeyedDataSource<Int, Image>() {
    companion object {
        const val FIRST_PAGE = 1
        const val MAX_PAGE_NUM = 50
        const val PAGE_SIZE = 20
        const val TAG = "ImageDataSource"
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Image>
    ) {
        val disposable = pixabayAPI.getImages(query, Key.API_KEY, FIRST_PAGE, PAGE_SIZE)
            .subscribeOn(Schedulers.io())
            .subscribeWith(object: ResourceSubscriber<PixabayResponse>(){
                override fun onNext(t: PixabayResponse?) {
                    Log.d(TAG, "loadInitial() - onNext()...")
                    t?.let {
                        callback.onResult(t.hits, null, FIRST_PAGE + 1)
                    }
                }

                override fun onError(t: Throwable?) {
                    Log.d(TAG, "onError()..")
                    t?.printStackTrace()
                }

                override fun onComplete() {
                }
            })
        compositeDisposable.add(disposable)
    }

    //when scrolling up - load previous page
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {

        Log.d(TAG, "requestedLoadsie: ${params.requestedLoadSize}")
        val disposable = pixabayAPI.getImages(query, Key.API_KEY, params.key, params.requestedLoadSize)  //TODO("requestedLoadSize?")
                .subscribeOn(Schedulers.io())
                .subscribeWith(object: ResourceSubscriber<PixabayResponse>(){
                    override fun onNext(t: PixabayResponse?) {
                        if (params.key< MAX_PAGE_NUM && t != null){
                            callback.onResult(t.hits, params.key-1)
                        }
                    }

                    override fun onError(t: Throwable?) {
                        t?.printStackTrace()
                    }

                    override fun onComplete() {
                    }
                })
        compositeDisposable.add(disposable)
    }

    //when scrolling down - load next page
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        Log.d(TAG, "loadAfter()...")
        val disposable = pixabayAPI.getImages(query, Key.API_KEY, params.key, params.requestedLoadSize)  //TODO("requestedLoadSize?")
            .subscribeOn(Schedulers.io())
            .subscribeWith(object: ResourceSubscriber<PixabayResponse>(){
                override fun onNext(t: PixabayResponse?) {
                    Log.d(TAG, "loadAfter() - onNext()...")
                    if (params.key< MAX_PAGE_NUM && t != null){
                        callback.onResult(t.hits, params.key+1)
                    }
                }

                override fun onError(t: Throwable?) {
                    t?.printStackTrace()
                }

                override fun onComplete() {
                }
            })
        compositeDisposable.add(disposable)
    }
}