package com.tapi.animationtranslate.youtube

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tapi.animationtranslate.R
import com.tapi.animationtranslate.youtube.YouTubeDemoViewHolder.*

class PhotosAdapter( val lists: List<Int>) :
    RecyclerView.Adapter<YouTubeDemoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouTubeDemoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.motion_24_recyclerview_expanded_text_header -> TextHeaderViewHolder(itemView)
            R.layout.motion_24_recyclerview_expanded_text_description -> TextDescriptionViewHolder(
                itemView
            )
            R.layout.motion_24_recyclerview_expanded_row -> CatRowViewHolder(itemView)
            else -> throw IllegalStateException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: YouTubeDemoViewHolder, position: Int) {
        when (holder) {
            is TextHeaderViewHolder -> {
            }
            is TextDescriptionViewHolder -> {
            }
            is CatRowViewHolder -> {
                val imagePosition = position - 2
                holder.textView.text =
                    holder.textView.resources.getString(R.string.cat_n, imagePosition)
                Glide.with(holder.imageView).load(lists[imagePosition]).into(holder.imageView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return when (position) {
            0 -> R.layout.motion_24_recyclerview_expanded_text_header
            1 -> R.layout.motion_24_recyclerview_expanded_text_description
            else -> R.layout.motion_24_recyclerview_expanded_row
        }
    }

    override fun getItemCount() = Cats.catImages.size + 2 // For text header and text description
}

sealed class YouTubeDemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class TextHeaderViewHolder(
        itemView: View
    ) : YouTubeDemoViewHolder(itemView)

    class TextDescriptionViewHolder(
        itemView: View
    ) : YouTubeDemoViewHolder(itemView)

    class CatRowViewHolder(
        itemView: View
    ) : YouTubeDemoViewHolder(itemView) {
        var imageView = itemView.findViewById(R.id.image_row) as ImageView
        var textView = itemView.findViewById(R.id.text_row) as TextView
    }

}

interface OnCallBack {
    fun setImage(index: Int)
}
