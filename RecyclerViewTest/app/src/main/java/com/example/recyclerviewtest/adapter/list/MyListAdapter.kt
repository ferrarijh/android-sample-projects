package com.example.recyclerviewtest.adapter.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerviewtest.MyDataSet
import com.example.recyclerviewtest.MyViewHolder
import com.example.recyclerviewtest.R

class MyListAdapter: ListAdapter<String, MyViewHolder>(
    object: DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String) = false
        override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    }
) {
    companion object{
        const val TAG = "MyListAdapter"
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "MyDataSet.list.size: ${MyDataSet.list.size}")
        holder.bind(currentList[position])
    }

}