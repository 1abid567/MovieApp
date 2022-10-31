package com.example.moviesapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.R
import com.example.moviesapp.ui.home.HomeActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        activityScope.launch {
            delay(4000)
            startActivity(Intent(this@SplashActivity,HomeActivity::class.java))
            finish()
        }
    }


    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }

}