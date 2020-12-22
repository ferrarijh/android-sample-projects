package com.example.pagingsample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.pagingsample.model.Image
import com.example.pagingsample.network.ImageDataSourceFactory
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val factory: ImageDataSourceFactory,
    val config: PagedList.Config
): ViewModel() {

    val liveImagePagedListWrapper = MutableLiveData<LiveData<PagedList<Image>>>()

    fun query(q: String?){
        q?.let{
            factory.query = it
            liveImagePagedListWrapper.value = LivePagedListBuilder(factory, config).build()
        }
    }
}