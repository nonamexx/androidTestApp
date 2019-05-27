package com.example.kotlinapp

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinapp.databinding.FragmentHomeTabTwoBinding

/**
 * Created by Pear on 4/2/2019.
 */
class HomeTabTwo: Fragment() {
    private lateinit var binding: FragmentHomeTabTwoBinding
    companion object {
        fun newInstance(): HomeTabTwo = HomeTabTwo()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_tab_two, container, false)
        return binding.root
    }
}