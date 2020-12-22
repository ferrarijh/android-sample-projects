package com.example.pagingsample.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.pagingsample.R
import com.example.pagingsample.model.Image

class ImageAdapter(
    val context: Context
): PagedListAdapter<Image, ImageViewHolder>(object: DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean = oldItem.pageURL == newItem.pageURL
}){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(currentList?.get(position))
    }

}