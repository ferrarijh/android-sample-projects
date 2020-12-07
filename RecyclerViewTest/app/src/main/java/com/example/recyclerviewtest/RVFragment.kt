package com.example.recyclerviewtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.adapter.diff.MyDiffAdapter
import com.example.recyclerviewtest.adapter.list.MyListAdapter
import com.example.recyclerviewtest.databinding.FragmentRvBinding

class RVFragment(private val mAdapter: RecyclerView.Adapter<MyViewHolder>): Fragment() {
    companion object{
        const val TAG = "RVFragment"
    }
    init{
        Log.d(TAG, "$this")
        Log.d(TAG, "adapter: $mAdapter")
    }

    private var _vBinding: FragmentRvBinding? = null
    private val vBinding
        get() = _vBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = FragmentRvBinding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter.setHasStableIds(true)  //now rv will animate without flickering with ListAdapter

        vBinding.rv.apply{
            adapter = when(mAdapter){
                is MyDiffAdapter -> mAdapter as MyDiffAdapter
                is MyListAdapter ->{
                    mAdapter.submitList(MyDataSet.list)
                    mAdapter as MyListAdapter
                }
                else -> throw Exception("unknown adapter type")
            }
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _vBinding = null
    }
}