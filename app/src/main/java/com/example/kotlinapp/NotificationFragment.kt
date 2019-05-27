package com.example.kotlinapp

import android.animation.Animator
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import com.example.kotlinapp.databinding.FragmentNotificationBinding

/**
 * Created by Pear on 4/2/2019.
 */
class NotificationFragment: Fragment() {
    private lateinit var binding: FragmentNotificationBinding
    companion object {
        fun newInstance(): NotificationFragment = NotificationFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.notificationRecyclerView.adapter = RecyclerNotificationAdapter(getOnClickNotification())
        return binding.root
    }

    private fun getOnClickNotification(): RecyclerNotificationAdapter.OnClickNotificationListener {
        return object : RecyclerNotificationAdapter.OnClickNotificationListener {
            override fun onClickNotification(position: Int) {
                Snackbar.make(binding.root, "Position click : $position", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}