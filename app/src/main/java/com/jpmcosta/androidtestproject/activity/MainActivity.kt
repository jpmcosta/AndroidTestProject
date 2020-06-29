package com.jpmcosta.androidtestproject.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.jpmcosta.androidtestproject.R

class MainActivity : AppCompatActivity() {

    companion object {

        private const val TAG: String = "recreate"

        private var recreateSeqNum: Int = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume() $this")

        val result = recreateSeqNum++ % 4
        if (result == 0) {
            Log.i(TAG, "ActivityCompat.recreate()")
            ActivityCompat.recreate(this)
        } else if (result == 2) {
            Log.i(TAG, "recreate()")
            recreate()
        }
    }
}