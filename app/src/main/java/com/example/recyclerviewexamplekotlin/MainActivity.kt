package com.example.recyclerviewexamplekotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewexamplekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie("title1", "https://loremflickr.com/320/240?lock=1"),
                Movie("title2", "https://loremflickr.com/320/240?lock=2"),
                Movie("title3", "https://loremflickr.com/320/240?lock=3"),
                Movie("title4", "https://loremflickr.com/320/240?lock=4"),
                Movie("title5", "https://loremflickr.com/320/240?lock=5"),
                Movie("title6", "https://loremflickr.com/320/240?lock=6"),
                Movie("title7", "https://loremflickr.com/320/240?lock=7"),
                Movie("title8", "https://loremflickr.com/320/240?lock=8"),
                Movie("title9", "https://loremflickr.com/320/240?lock=9"),
                Movie("title10", "https://loremflickr.com/320/240?lock=10"),
            )
        )
        { movie ->
            Toast.makeText(this@MainActivity, movie.title, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}