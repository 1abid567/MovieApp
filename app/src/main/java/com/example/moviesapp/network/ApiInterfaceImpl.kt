package com.example.moviesapp.network

import javax.inject.Inject

class ApiInterfaceImpl @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getMovies(page:String?,limit:Int) = apiInterface.listMovies(page,limit)
}