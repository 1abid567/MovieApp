package com.example.moviesapp.ui.home.homefragment.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.MovieItemDataBinding
import com.example.moviesapp.ui.home.homefragment.model.Movie

class MovieViewHolder(
    val binding: MovieItemDataBinding?
) : RecyclerView.ViewHolder(binding?.root!!) {

    fun setData(movie: Movie) {
        Glide.with(binding!!.root).load(movie.url).into(binding.movieImageview)
        binding.movieName.text=movie.title
    }
}