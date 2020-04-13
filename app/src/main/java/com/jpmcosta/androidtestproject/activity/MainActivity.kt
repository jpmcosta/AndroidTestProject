package com.jpmcosta.androidtestproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jpmcosta.androidtestproject.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}