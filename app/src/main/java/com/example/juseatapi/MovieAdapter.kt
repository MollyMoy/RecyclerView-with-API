package com.example.juseatapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>(){

    private val movies = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindModel(movies[position])
    }

    fun setMovies(data : List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    }



