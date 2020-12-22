package com.example.pagingsample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProviderFactory @Inject constructor(
    val providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return providerMap[modelClass]?.get() as T ?: throw RuntimeException("Unsupported ViewModel type")
    }
}