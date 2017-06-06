package com.jpmcosta.androidtestproject.activity

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.crashlytics.android.Crashlytics
import com.jpmcosta.androidtestproject.R
import io.fabric.sdk.android.Fabric

class MainActivity : AppCompatActivity() {

    @BindView(android.R.id.text1)
    lateinit var text1TextView: TextView

    @OnClick(R.id.fab)
    fun onClick(fab: FloatingActionButton) {
        startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This causes "enabled_notification_listeners" to not properly update.
        Fabric.with(this, Crashlytics())

        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
    }

    override fun onStart() {
        super.onStart()

        text1TextView.text = Settings.Secure.getString(contentResolver, "enabled_notification_listeners")
    }
}