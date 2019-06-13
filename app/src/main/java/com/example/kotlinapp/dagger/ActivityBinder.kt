package com.example.kotlinapp.dagger

import android.app.Activity
import com.example.kotlinapp.HomeFragment
import com.example.kotlinapp.MainActivity
import com.example.kotlinapp.ProfileFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * Created by Pear on 6/12/2019.
 */
@Module(includes = [
    ViewModelModule::class
])
abstract class ActivityBinder {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun profileFragment(): ProfileFragment
}