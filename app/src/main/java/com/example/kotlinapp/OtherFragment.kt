package com.example.kotlinapp

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.databinding.FragmentOtherBinding
import dagger.android.support.DaggerFragment

/**
 * Created by Pear on 4/2/2019.
 */
class OtherFragment: Fragment() {
    private lateinit var binding: FragmentOtherBinding
    private lateinit var viewModel: GithubUserViewModel
    companion object {
        fun newInstance(): OtherFragment = OtherFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GithubUserViewModel::class.java)
        observeViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_other, container, false)
        viewModel.searchUserInGithub("no")
        binding.githubUserRecycler.layoutManager = LinearLayoutManager(context)
//        binding.githubUserRecycler.adapter = GithubUserAdapter()
        return binding.root
    }

    private fun observeViewModel() {
        viewModel.userDataLiveData.observe(this, Observer {
            Toast.makeText(context, "Complete", Toast.LENGTH_SHORT).show()
            if (it.total_count > 0) {
                binding.githubUserRecycler.adapter = GithubUserAdapter(it.users)
            }
        })

        viewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        })
    }
}