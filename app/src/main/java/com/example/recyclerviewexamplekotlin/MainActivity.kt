package com.example.recyclerviewexamplekotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.recyclerviewexamplekotlin.databinding.ActivityMainBinding
import com.example.recyclerviewexamplekotlin.model.Movie
import com.example.recyclerviewexamplekotlin.model.MovieDbClient
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moviesAdapter = MoviesAdapter(emptyList())
        {
           navigateTo(it)
        }
        binding.recycler.adapter = moviesAdapter

        lifecycleScope.launch{
            val apiKey = getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.listPopularMovies(apiKey)
                moviesAdapter.movies = popularMovies.results
                moviesAdapter.notifyDataSetChanged()


        }

    }

    private fun navigateTo(movie: Movie) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)

        startActivity(intent)
    }

}