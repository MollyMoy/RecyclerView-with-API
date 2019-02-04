package com.example.juseatapi

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_movie_layout.view.*

class MovieViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    val heading: TextView =  itemView.movie_title

    fun bindModel (movie : Movie) {
        heading.text = movie.title
    }


}