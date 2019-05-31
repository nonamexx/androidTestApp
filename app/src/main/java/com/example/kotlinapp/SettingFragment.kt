package com.example.kotlinapp

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import com.example.kotlinapp.databinding.FragmentSettingBinding

/**
 * Created by Pear on 4/29/2019.
 */
class SettingFragment: Fragment() {
    private lateinit var binding: FragmentSettingBinding

    companion object {
        // test
        fun newInstance(): SettingFragment = SettingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.notificationButton.setOnClickListener {
            callNotification()
        }
    }

    private fun callNotification() {
        // only activity
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            action = "open_notification"
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val notificationId = 0
        val manager = context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(context!!, "test_notification")
            .setSmallIcon(R.drawable.ic_flag_notification)
            .setContentTitle("Notification!")
            .setContentText("Do you see me?")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent) // nah
            .setAutoCancel(true)
            .build()
        manager.notify(notificationId, notification)
    }
}