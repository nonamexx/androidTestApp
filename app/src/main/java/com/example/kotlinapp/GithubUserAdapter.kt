package com.example.kotlinapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinapp.databinding.LayoutGithubUserBinding

/**
 * Created by Pear on 6/13/2019.
 */
class GithubUserAdapter(private val githubUserList: List<User>) : RecyclerView.Adapter<GithubUserAdapter.ViewHolder>() {
    private val color = intArrayOf(R.color.colorAccent)
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GithubUserAdapter.ViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return ViewHolder(DataBindingUtil.inflate(inflater, R.layout.layout_github_user, p0, false))
    }

    override fun getItemCount(): Int {
        return githubUserList.size
    }

    override fun onBindViewHolder(p0: GithubUserAdapter.ViewHolder, p1: Int) {
        p0.apply {
            setBackgroundColor()
            setTag(p1)
            setUserImage(githubUserList[p1].avatar_url)
            setId(githubUserList[p1].id)
            setName(githubUserList[p1].login)
        }
    }

    inner class ViewHolder(private val binding: LayoutGithubUserBinding): RecyclerView.ViewHolder(binding.root){
        fun setBackgroundColor(){

        }

        fun setTag(position: Int){

        }

        fun setUserImage(url: String) {
            Glide.with(itemView)
                .load(url)
                .into(binding.githubUserImage)
        }

        fun setId(id: Int) {
            binding.githubId.text = id.toString()
        }

        fun setName(name: String) {
            binding.githubUsername.text = name
        }
    }
}