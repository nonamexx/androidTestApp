package com.example.kotlinapp

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinapp.databinding.FragmentOtherBinding

/**
 * Created by Pear on 4/2/2019.
 */
class OtherFragment: Fragment() {
    private lateinit var binding: FragmentOtherBinding
    companion object {
        fun newInstance(): OtherFragment = OtherFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_other, container, false)
        return binding.root
    }
}