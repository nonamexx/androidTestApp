package com.example.kotlinapp

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinapp.databinding.FragmentSettingBinding

/**
 * Created by Pear on 4/29/2019.
 */
class SettingFragment: Fragment() {
    private lateinit var binding: FragmentSettingBinding

    companion object {
        fun newInstance(): SettingFragment = SettingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        return binding.root
    }
}