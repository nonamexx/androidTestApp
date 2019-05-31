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
import com.example.kotlinapp.databinding.FragmentProfileBinding

/**
 * Created by Pear on 4/4/2019.
 */
class ProfileFragment: Fragment() {
    private lateinit var binding: FragmentProfileBinding

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileEditButton.setOnClickListener {
            callNotification()
        }
    }

    private fun callNotification() {
        // nah nah nah
        val intent = Intent(context, NotificationFragment::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val notificationId = 0
        val manager = context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(context!!, "test_notification")
            .setSmallIcon(R.drawable.ic_menu_share)
            .setContentTitle("Notification!")
            .setContentText("Do you see me?")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent) // nah
            .setAutoCancel(true)
            .build()
        manager.notify(notificationId, notification)
    }
}