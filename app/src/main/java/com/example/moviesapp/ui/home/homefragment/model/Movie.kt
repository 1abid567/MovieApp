package com.example.moviesapp.ui.home.homefragment.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
data class Movie(
    val uid: Int,
    val id: Int,
    val url: String,
    val imdb_code: String,
    val title: String,
    val title_english: String,
    val title_long: String,
    val slug: String = "",
    val year: Int,
    val rating: Double,
    val runtime: Int,
    val genres: ArrayList<String>,
    val description_full: String,
    @SerializedName("yt_trailer_code")
    val yt_trailer_id: String,
    val language: String,
    val mpa_rating: String,
    val background_image: String,
    val small_cover_image: String,
    val medium_cover_image: String,
    val large_cover_image: String,
    val date_uploaded: String,
    val date_uploaded_unix: String
) : Serializable