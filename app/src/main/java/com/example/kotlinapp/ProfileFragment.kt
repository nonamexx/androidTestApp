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
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by Pear on 4/4/2019.
 */
class ProfileFragment: DaggerFragment() {
    @Inject
    lateinit var someData: SomeData

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
        binding.profileUserName.text = someData.name
        binding.textTitle.text = "Favourite : ${someData.favourite}"
        binding.profileEditButton.setOnClickListener {

        }
    }

}