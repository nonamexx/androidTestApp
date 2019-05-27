package com.example.kotlinapp

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.kotlinapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){
    private lateinit var binding: FragmentHomeBinding

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        setTabLayout()
        return binding.root
    }

    private fun setTabLayout(){
        val adapter = HomeViewPagerAdapter(fragmentManager, binding.tabLayoutForHome.tabCount)
        binding.tabLayoutForHome.setupWithViewPager(binding.tabContent)
        binding.tabContent.adapter = adapter

        binding.tabContent.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayoutForHome))
        binding.tabLayoutForHome.addOnTabSelectedListener(object:
        TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                binding.tabContent.currentItem = p0!!.position
            }
        })
    }

}