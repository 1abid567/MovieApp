package com.example.moviesapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.R
import com.example.moviesapp.base.BaseActivity
import com.example.moviesapp.utils.AppUtils.makeStatusBarTransparent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        makeStatusBarTransparent()
    }
}