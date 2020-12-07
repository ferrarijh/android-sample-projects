package com.example.navigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationtest.databinding.Fragment11Binding
import com.example.navigationtest.databinding.Fragment21Binding

class Fragment21: Fragment() {
    private var _vBinding: Fragment21Binding? = null
    private val vBinding
        get() = _vBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = Fragment21Binding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vBinding.btnF21.setOnClickListener{
            findNavController().navigate(R.id.fragment12)
        }
    }
}