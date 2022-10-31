package com.example.moviesapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.MyApplication

open class BaseActivity  : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.get()?.activity = this@BaseActivity

    }

}