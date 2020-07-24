package com.franz.notificationlistenertutorial

import android.app.Notification
import android.content.Context
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

/**
 * Created by Franz Andel on 03/06/20.
 * Android Engineer
 */

class NotificationService: NotificationListenerService() {

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    override fun onListenerConnected() {
        super.onListenerConnected()
        // Check if Notification Listener Permission is allowed
        Log.d("1234", "onListenerConnected")
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        // Check if Notification Listener Permission is not allowed
        Log.d("1234", "onListenerDisconnected")
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        // PostTime in milliseconds
        val postTime = sbn?.postTime
        val extras = sbn?.notification?.extras
        val notificationTitle = extras?.getString(Notification.EXTRA_TITLE)
        val notificationDescription = extras?.getString(Notification.EXTRA_TEXT)
        // For Notification with Big Text
        val notificationBigDescription = extras?.getString(Notification.EXTRA_BIG_TEXT)

        Log.d("1234", "Posted Time : $postTime")
        Log.d("1234", "Posted Package Name : ${sbn?.packageName}")
        Log.d("1234", "Posted notificationTitle : $notificationTitle")
        Log.d("1234", "Posted notificationDescription : $notificationDescription")
        Log.d("1234", "Posted notificationBigDescription : $notificationBigDescription")
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
        Log.d("1234", "Removed Package Name : ${sbn?.packageName}")
    }
}