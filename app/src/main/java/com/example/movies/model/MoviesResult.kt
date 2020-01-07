package com.example.movies.model

import com.example.movies.model.Movie
import com.google.gson.annotations.SerializedName


@Suppress("ArrayInDataClass")
data class MoviesResult (
    @SerializedName("results") var movies: Array<Movie>
)