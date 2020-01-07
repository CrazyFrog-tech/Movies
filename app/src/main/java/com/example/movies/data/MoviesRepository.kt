package com.example.movies.data

import com.example.movies.model.MoviesResult

class MoviesRepository {
    private val moviesApi: MoviesApiService = MoviesApi.createApi()

    fun getMoviesByReleaseYear(releaseYear: Int): retrofit2.Call<MoviesResult> = moviesApi.getMoviesByReleaseYear(releaseYear)
}