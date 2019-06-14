package com.example.kotlinapp.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider
import com.example.kotlinapp.GithubUserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.Provides



/**
 * Created by Pear on 6/14/2019.
 */
@Module
abstract class ViewModelModule {
    // For viewModel that we want to inject
    @Binds
    @IntoMap
    @ViewModelKey(GithubUserViewModel::class)
    abstract fun bindGithubUserViewModel(viewModel: GithubUserViewModel): ViewModel
}