package com.example.moviesapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var _binding : FragmentHomeBinding

    private val binding get() = _binding


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


    override fun onDestroy() {
        _binding.unbind()
        super.onDestroy()
    }

}