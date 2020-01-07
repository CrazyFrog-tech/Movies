package com.example.movies.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.data.MoviesApi
import com.example.movies.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*
import java.lang.Exception

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        initViews()
    }


    private fun initViews() {
        val bundle = intent.extras
        if (bundle != null) {
            val movie: Movie = bundle.get("Movie") as Movie
            Glide.with(this).load(MoviesApi.imageBaseUrl + movie.backDrop).into(ivBackdrop)
            Glide.with(this).load(MoviesApi.imageBaseUrl + movie.poster).into(ivPoster)
            tvTitle.text = movie.title
            tvReleaseDate.text = getString(R.string.release_date, movie.releaseDate)
            tvRating.text = movie.rating.toString()
            tvPlot.text = movie.plot
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return try {
            finish()
            true
        } catch (e: Exception) {
            false
        }
    }
}
