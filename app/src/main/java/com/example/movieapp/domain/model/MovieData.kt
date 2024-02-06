package com.example.movieapp.domain.model

import com.example.movieapp.data.dto.Rating
import com.squareup.moshi.Json

data class MovieData(
    val actors: String,
    val awards: String,
    val boxOffice: String,
    val country: String,
    val director: String,
    val genre: String,
    val imdbID: String,
    val imdbRating: String,
    val language: String,
    val plot: String,
    val poster: String,
    val production: String,
    val rated: String,
    val ratings: List<Rating>,
    val released: String,
    val runtime: String,
    val title: String,
    val writer: String,
    val year: String
)