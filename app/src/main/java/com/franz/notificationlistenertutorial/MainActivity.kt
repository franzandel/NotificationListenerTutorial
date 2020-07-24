package com.franz.notificationlistenertutorial

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val NOTIFICATION_CHANNEL_ID = "10001"
    private val default_notification_channel_id = "default"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSendPN.setOnClickListener {
            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val mBuilder = NotificationCompat.Builder(this@MainActivity, default_notification_channel_id)
            mBuilder.setContentTitle("My Notification")
            mBuilder.setContentText("Notification Listener Service Example")
            mBuilder.setTicker("Notification Listener Service Example")
            mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground)
            mBuilder.setAutoCancel(true)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val importance = NotificationManager.IMPORTANCE_HIGH
                val notificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance)
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID)
                assert(mNotificationManager != null)
                mNotificationManager!!.createNotificationChannel(notificationChannel)
            }
            assert(mNotificationManager != null)
            mNotificationManager!!.notify(System.currentTimeMillis().toInt(), mBuilder.build())
        }

        btnGoToSettings.setOnClickListener {
            startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
        }
    }
}
