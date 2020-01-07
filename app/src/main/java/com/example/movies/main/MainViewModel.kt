package com.example.movies.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.movies.data.MoviesRepository
import com.example.movies.model.Movie
import com.example.movies.model.MoviesResult
import retrofit2.Call
import retrofit2.Response

class MainViewModel (application: Application) : AndroidViewModel(application) {

    private val moviesRepository = MoviesRepository()
    val movies = MutableLiveData<Array<Movie>>()
    val error = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>(false)

    fun getMoviesByReleaseYear(releaseYear: Int){
        isLoading.value = true
        moviesRepository.getMoviesByReleaseYear(releaseYear)
            .enqueue(object : retrofit2.Callback<MoviesResult> {
                override fun onResponse(
                    call: Call<MoviesResult>,
                    response: Response<MoviesResult>
                ) {
                    isLoading.value = false
                    if (response.isSuccessful) movies.value = response.body()?.movies
                    else error.value = "An error occurred: ${response.errorBody().toString()}"
                }

                override fun onFailure(call: Call<MoviesResult>, t: Throwable) {
                    error.value = t.message
                    isLoading.value = false
                }
            })
    }

}