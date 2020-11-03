package com.slavetny.findphotos.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.slavetny.findphotos.data.db.HistoryPhoto
import kotlinx.android.synthetic.main.photo_item.view.*

class HistoryPhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(photo: HistoryPhoto) {
        Glide.with(itemView)
            .load(photo.photoUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(itemView.photoPlace)

        itemView.photoKeyWord.text = photo.keyWord
    }
}