package com.example.kotlinapp

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kotlinapp.databinding.LayoutExploreCardBinding

/**
 * Created by Pear on 4/23/2019.
 */
class RecyclerExploreAdapter: RecyclerView.Adapter<RecyclerExploreAdapter.ViewHolder>() {
    private val color = intArrayOf(R.color.colorAccent)
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerExploreAdapter.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return ViewHolder(DataBindingUtil.inflate(inflater, R.layout.layout_explore_card, p0, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: RecyclerExploreAdapter.ViewHolder, p1: Int) {
        p0.apply {
            setBackgroundColor()
            setTag(p1)
        }
    }

    inner class ViewHolder(private val binding: LayoutExploreCardBinding): RecyclerView.ViewHolder(binding.root){
        fun setBackgroundColor(){

        }

        fun setTag(position: Int){

        }
    }
}