package com.sairam.services20

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class RunningService: Service() {
    override fun onBind(intent: Intent?): IBinder? { // this fun recieves intent nd returns binder
      // u can have one instamce nd multiple binds connected to single instance
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }
    private fun start(){
        // with Builder() we can customize our own notification
        // here
        val notification = NotificationCompat.Builder(this, "running_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("xyz service is active")
            .setContentText("time left: 5:30")
            .build()
        startForeground(1, notification) // never choose 0 as id
    }
    enum class Actions(){
        START,
        STOP
    }
}