package com.example.moviesapp.ui.home.homefragment.model


data class Movies(val movie: Movie?, val movie_count: Int, val movies: List<Movie> =ArrayList(),
                  val limit: Int, val page_number: String)

