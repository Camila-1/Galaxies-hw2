package com.example.galaxies

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
        item_image.setImageResource(item.image)
        item_title.text = item.title
        item_description.text = item.description
        setOnClickListener{listener(item)}
    }
}