package com.example.movies.data

import com.example.movies.model.MoviesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {
    @GET("movie?api_key=9dcdbaf64a1ab1c22224a56ba2f3ef4c&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getMoviesByReleaseYear(@Query(value = "primary_release_year", encoded = true) releaseYear: Int): Call<MoviesResult>

}