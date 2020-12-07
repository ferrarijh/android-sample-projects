package com.example.recyclerviewtest.adapter.diff

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.MyDataSet
import com.example.recyclerviewtest.MyViewHolder
import com.example.recyclerviewtest.R
import com.example.recyclerviewtest.adapter.list.MyListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyDiffAdapter: RecyclerView.Adapter<MyViewHolder>() {
    companion object{
        const val TAG = "MyDiffAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.d(TAG, "MyDataSet.list.size: ${MyDataSet.list.size}")
        holder.bind(MyDataSet.list[position])
    }

    override fun getItemCount() = MyDataSet.list.size

    fun updateList(newList: List<String>){
        val callback = MyDiffCallback(MyDataSet.list, newList)
        CoroutineScope(Dispatchers.Main).launch {
            val diffResult = withContext(Dispatchers.Default){
                DiffUtil.calculateDiff(callback)
            }    //this is 'expensive', so call it in worker thread
            Log.d(TAG, "getItemCount(): $itemCount")
            Log.d(TAG, "MyDataSet.list.size: ${MyDataSet.list.size}")
            MyDataSet.list.clear()
            MyDataSet.list.addAll(newList)
            diffResult.dispatchUpdatesTo(this@MyDiffAdapter)

            MyDataSet.list = newList as MutableList<String>
        }
    }

}