package com.example.kotlinapp

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinapp.databinding.FragmentExploreBinding

/**
 * Created by Pear on 4/2/2019.
 */
class ExploreFragment: Fragment(){
    private lateinit var binding: FragmentExploreBinding
    companion object {
        fun newInstance(): ExploreFragment = ExploreFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_explore, container, false)
        binding.exploreRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.exploreRecyclerView.adapter = RecyclerExploreAdapter()
        return binding.root
    }
}