package com.example.moviesapp.ui.home.homefragment.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviesapp.network.ApiInterfaceImpl
import com.example.moviesapp.ui.home.homefragment.model.Movie

class AllMoviesPaggingSource(private val limit:Int,private val apiInterfaceImpl: ApiInterfaceImpl): PagingSource<String, Movie>() {


    override suspend fun load(params: LoadParams<String>): LoadResult<String, Movie> {
        return try {
            val response = apiInterfaceImpl.getMovies(
                    page = if (params is LoadParams.Append) params.key else null,
                    limit = limit)

            LoadResult.Page(
                data = if (response.body()?.data?.movies?.isEmpty() == true) ArrayList() else response.body()?.data!!.movies,
                prevKey = null,
                nextKey = response.body()?.data?.page_number + 1
            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<String, Movie>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            // This loads starting from previous page, but since PagingConfig.initialLoadSize spans
            // multiple pages, the initial load will still load items centered around
            // anchorPosition. This also prevents needing to immediately launch prepend due to
            // prefetchDistance.
            state.closestPageToPosition(anchorPosition)?.nextKey
        }
    }
}