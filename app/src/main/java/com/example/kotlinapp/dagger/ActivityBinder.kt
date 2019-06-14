package com.example.kotlinapp.dagger

import android.app.Activity
import com.example.kotlinapp.HomeFragment
import com.example.kotlinapp.MainActivity
import com.example.kotlinapp.OtherFragment
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
@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun mainActivity(): MainActivity

}