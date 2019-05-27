package com.example.kotlinapp

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.example.kotlinapp.databinding.LayoutCardBinding
import android.view.ViewGroup
import android.view.animation.AnimationUtils

class RecyclerCardViewAdapter : RecyclerView.Adapter<RecyclerCardViewAdapter.ViewHolder>() {

    private val titles = arrayOf("Element One",
        "Element Two", "Element Three", "Element Four",
        "Element Five", "Element Six", "Element Seven",
        "Element Eight", "Element Nine", "Element Ten")

    private val images = intArrayOf(R.drawable.img_card,
        R.drawable.img_card, R.drawable.img_card, R.drawable.img_card,
        R.drawable.img_card, R.drawable.img_card, R.drawable.img_card,
        R.drawable.img_card, R.drawable.img_card, R.drawable.img_card)

    private var lastPosition = -1

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return ViewHolder(DataBindingUtil.inflate(inflater, R.layout.layout_card, p0, false))
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.apply {
            setTitle(titles[p1])
            setImage(images[p1])
        }
//        val animator = AnimationUtils.loadAnimation(p0.itemView.context,
//            if (p1 > lastPosition){
//                R.anim.animation_right_to_left
//            } else {
//                R.anim.animation_left_to_right
//            })
//        p0.itemView.startAnimation(animator)
//        lastPosition = p1
    }

    inner class ViewHolder(private val binding: LayoutCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun setTitle(titleText: String){
            binding.textInCard.text = titleText
        }
        fun setImage(image: Int){
            binding.imageInCard.setImageResource(image)
        }
    }
}