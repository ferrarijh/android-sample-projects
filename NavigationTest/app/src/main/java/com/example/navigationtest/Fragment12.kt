package com.example.navigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationtest.databinding.Fragment11Binding
import com.example.navigationtest.databinding.Fragment12Binding

class Fragment12: Fragment() {
    private var _vBinding: Fragment12Binding? = null
    private val vBinding
        get() = _vBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = Fragment12Binding.inflate(inflater, container, false)
        return vBinding.root
    }
}