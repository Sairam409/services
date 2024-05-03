package com.sairam.services20

import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class RunningApp :Application() {
    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                "running_channel", // should be same as we defined while creating notification
                "running_notifications", // user sees this in app settings -> wt kind of notifications does app send
                // ex: "notificatio related to post", " story activity", " a new request" in instagram
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}