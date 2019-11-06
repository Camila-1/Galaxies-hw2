package com.example.galaxies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class Adapter(private val items: List<Item>, private val listener: (Item) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = with(parent) {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, this, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)


    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
            item_image.setImageResource(item.image)
            item_title.text = item.title
            item_description.text = item.description
            setOnClickListener{listener(item)}
        }
    }
}