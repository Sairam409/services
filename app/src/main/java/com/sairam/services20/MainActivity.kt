package com.sairam.services20

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.sairam.services20.ui.theme.Services20Theme
import android.Manifest;


class MainActivity : ComponentActivity() {
    @SuppressLint("ObsoleteSdkInt", "InlinedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { //TIRAMISU represents version
          ActivityCompat.requestPermissions(
              this, arrayOf(Manifest.permission.POST_NOTIFICATIONS),
              0
          )
      }
        setContent {
            Services20Theme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        Intent(applicationContext, RunningService::class.java).also {
                            it.action = RunningService.Actions.START.toString()
                            startService(it)
                        }
                    }) {
                        Text(text = "start service")
                    }
                    Button(onClick = {
                        Intent(applicationContext, RunningService::class.java).also {
                            it.action = RunningService.Actions.STOP.toString()
                            startService(it)
                        }
                    }) {
                        Text(text = "stop service")
                    }
                }
            }
        }
    }
}



