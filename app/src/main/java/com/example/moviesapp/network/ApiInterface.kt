package com.example.moviesapp.network

import com.example.moviesapp.ui.home.homefragment.model.MovieResponse
import com.example.moviesapp.utils.Constants.Companion.MOVIE_API
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(MOVIE_API)
   suspend fun listMovies(@Query("page") page: String?,@Query("limit") limit : Int): Response<MovieResponse>
}