package com.example.moviesapp.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.LoadStateViewDataBinding

class AppLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<AppLoadStateAdapter.LoadStateViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            LoadStateViewDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }


    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {

        val progress = holder.loadStateViewBinding.loadStateProgress
        val btnRetry = holder.loadStateViewBinding.loadStateRetry
        val txtErrorMessage = holder.loadStateViewBinding.loadStateErrorMessage

        btnRetry.isVisible = loadState !is LoadState.Loading
        txtErrorMessage.isVisible = loadState !is LoadState.Loading
        progress.isVisible = loadState is LoadState.Loading

        if (loadState is LoadState.Error) {
            if (loadState.error.localizedMessage?.contains("") == true)
                txtErrorMessage.text = ""
            else
                txtErrorMessage.text = loadState.error.localizedMessage
        }

        btnRetry.setOnClickListener {
            retry.invoke()
        }
    }

    class LoadStateViewHolder(val loadStateViewBinding: LoadStateViewDataBinding) :
        RecyclerView.ViewHolder(loadStateViewBinding.root)
}