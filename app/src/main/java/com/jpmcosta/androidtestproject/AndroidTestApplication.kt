package com.jpmcosta.androidtestproject

import android.app.Application
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.jpmcosta.androidtestproject.work.TestWorker

class AndroidTestApplication : Application(), Configuration.Provider {

    override fun onCreate() {
        super.onCreate()

        val periodicWorkRequest = TestWorker.getPeriodicWorkRequest()
        val workManager = WorkManager.getInstance(this@AndroidTestApplication)
        workManager.enqueueUniquePeriodicWork(TestWorker.TAG, ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest)
    }

    override fun getWorkManagerConfiguration(): Configuration =
            Configuration.Builder()
                    .setMinimumLoggingLevel(android.util.Log.DEBUG)
                    .build()
}