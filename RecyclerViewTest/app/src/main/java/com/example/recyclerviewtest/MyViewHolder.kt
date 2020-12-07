package com.example.recyclerviewtest

import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(val item: View): RecyclerView.ViewHolder(item){
    fun bind(data: String){
//        item.startAnimation(AnimationUtils.loadAnimation(item.context, R.anim.item_rv_appear))
        val tvItem = item.findViewById<TextView>(R.id.tv_item)
        tvItem.text = data
    }
}