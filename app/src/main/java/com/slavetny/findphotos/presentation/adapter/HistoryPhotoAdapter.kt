package com.slavetny.findphotos.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slavetny.findphotos.R
import com.slavetny.findphotos.data.db.HistoryPhoto
import com.slavetny.findphotos.domain.extensions.inflate

class HistoryPhotoAdapter : RecyclerView.Adapter<HistoryPhotoViewHolder>() {

    private var photoList: List<HistoryPhoto> = emptyList()

    fun attachData(photoList: List<HistoryPhoto>) {
        this.photoList = photoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HistoryPhotoViewHolder(
            parent.inflate(R.layout.photo_item)
        )

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: HistoryPhotoViewHolder, position: Int) {
        holder.bind(photoList[position])
    }
}