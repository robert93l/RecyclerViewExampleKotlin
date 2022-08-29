package com.example.recyclerviewexamplekotlin.model

import com.google.gson.annotations.SerializedName

data class MovieDbResult(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)