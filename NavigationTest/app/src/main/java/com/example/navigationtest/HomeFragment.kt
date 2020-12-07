package com.example.navigationtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.navigationtest.databinding.Fragment21Binding
import com.example.navigationtest.databinding.FragmentHomeBinding

class HomeFragment: Fragment(){
    companion object{
        const val TAG = "HomeFragment"
    }

    private val parent by lazy{requireActivity() as AppCompatActivity}
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

    override fun onStart() {
        super.onStart()
        parent.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
    }

    override fun onStop() {
        super.onStop()
        parent.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()..")
    }
}