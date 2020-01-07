package com.example.movies.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.data.MoviesApi
import com.example.movies.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*


@SuppressLint("SetTextI18n")
class MovieAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }

        fun bind(movie: Movie) {
            itemView.tvNumber.text = "${adapterPosition + 1}."
            Glide.with(context).load(MoviesApi.imageBaseUrl + movie.poster).into(itemView.ivMovie)
        }
    }

}