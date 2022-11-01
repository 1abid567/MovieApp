package com.example.moviesapp.ui.home.homefragment

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.moviesapp.base.BaseViewModel
import com.example.moviesapp.network.ApiInterfaceImpl
import com.example.moviesapp.ui.home.homefragment.model.Movie
import com.example.moviesapp.ui.home.homefragment.pagingsource.AllMoviesPaggingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val apiInterfaceImpl: ApiInterfaceImpl):BaseViewModel() {

    val response: Flow<PagingData<Movie>> = getAllReviewsListStream()

    private fun getAllReviewsListStream(): Flow<PagingData<Movie>> {
        return Pager(PagingConfig(pageSize = 20)) {
            AllMoviesPaggingSource(20, apiInterfaceImpl = apiInterfaceImpl)
        }.flow.cachedIn(viewModelScope)
    }



}