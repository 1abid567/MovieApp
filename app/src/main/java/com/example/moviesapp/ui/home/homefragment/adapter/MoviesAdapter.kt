package com.example.moviesapp.ui.home.homefragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.moviesapp.databinding.MovieItemDataBinding
import com.example.moviesapp.ui.home.homefragment.model.Movie
import com.example.moviesapp.utils.toJson

class MoviesAdapter :
    PagingDataAdapter<Movie, MovieViewHolder>(AllMovieModelComparator) {


    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieItemDataBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

    }

    companion object {
        private val AllMovieModelComparator = object : DiffUtil.ItemCallback<Movie>() {
                override fun areItemsTheSame(
                    oldItem: Movie,
                    newItem: Movie
                ): Boolean {
                    return (oldItem.toJson() == newItem.toJson())
                }

                override fun areContentsTheSame(
                    oldItem: Movie,
                    newItem: Movie
                ): Boolean = oldItem.toJson() == newItem.toJson()
            }
    }
}