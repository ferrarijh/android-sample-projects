package com.example.navigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationtest.databinding.Fragment21Binding
import com.example.navigationtest.databinding.FragmentHomeBinding

class HomeFragment: Fragment(){
    private var _vBinding: FragmentHomeBinding? = null
    private val vBinding
        get() = _vBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return vBinding.root
    }
}