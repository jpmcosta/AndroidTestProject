package com.jpmcosta.androidtestproject.work

import android.content.Context
import android.util.Log
import androidx.work.*
import java.util.concurrent.TimeUnit

class TestWorker(applicationContext: Context, workerParameters: WorkerParameters) :
        CoroutineWorker(applicationContext, workerParameters) {

    companion object {

        val TAG = TestWorker::class.java.simpleName

        private const val REPEAT_INTERVAL = 15L

        private val REPEAT_INTERVAL_TIME_UNIT = TimeUnit.MINUTES


        fun getPeriodicWorkRequest(): PeriodicWorkRequest {
            val constraints = Constraints.Builder()
                    .setRequiresCharging(true)
                    .build()
            return PeriodicWorkRequestBuilder<TestWorker>(REPEAT_INTERVAL, REPEAT_INTERVAL_TIME_UNIT)
                    .setConstraints(constraints)
                    .build()
        }
    }


    override suspend fun doWork(): Result {
        Log.i(TAG, "Worker doing work!")

        return Result.success()
    }
}