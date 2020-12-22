package com.example.pagingsample.ui

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.pagingsample.R
import com.example.pagingsample.model.Image

class ImageViewHolder(iView: View): RecyclerView.ViewHolder(iView) {
    fun bind(image: Image?){
        val pb = itemView.findViewById<ProgressBar>(R.id.pb)
        val ivItem = itemView.findViewById<ImageView>(R.id.iv_item)
        if (image == null){
            pb.visibility = View.GONE
            ivItem.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.ic_baseline_error_24))
        } else{
            val tvUser = itemView.findViewById<TextView>(R.id.tv_item_user)
            val tvDownloads = itemView.findViewById<TextView>(R.id.tv_item_downloads)
            val tvLikes = itemView.findViewById<TextView>(R.id.tv_item_likes)

            Glide.with(itemView.context)
                .load(image.previewURL)
                .error(R.drawable.ic_baseline_error_24)
                .addListener(object: RequestListener<Drawable>{
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        pb.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        pb.visibility = View.GONE
                        return false
                    }

                })
                .into(ivItem)

            tvUser.text = image.user
            tvDownloads.text = image.downloads.toString()
            tvLikes.text = image.likes.toString()
        }
    }
}