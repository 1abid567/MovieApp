package com.example.moviesapp.ui.home.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.base.BaseFragment
import com.example.moviesapp.databinding.FragmentHomeBinding
import com.example.moviesapp.ui.home.homefragment.adapter.MoviesAdapter
import com.example.moviesapp.utils.AppLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    lateinit var _binding : FragmentHomeBinding
    private val viewModel :HomeViewModel by viewModels()
    private val binding get() = _binding
    private val allMoviesAdapter: MoviesAdapter by lazy { MoviesAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentHomeBinding.inflate(inflater,container,false).apply {
            lifecycleOwner=this@HomeFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.response.collectLatest {
                allMoviesAdapter.submitData(it)
            }
        }

        binding.allMoviesRecyclerview.apply {
            hasFixedSize()
            layoutManager=GridLayoutManager(requireContext(),2)
            adapter = allMoviesAdapter.withLoadStateFooter(
                footer = AppLoadStateAdapter { allMoviesAdapter.retry() }
            )
        }

    }


    override fun onDestroy() {
        _binding.unbind()
        super.onDestroy()
    }

}