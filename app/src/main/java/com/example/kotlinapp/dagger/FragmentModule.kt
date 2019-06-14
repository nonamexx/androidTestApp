package com.example.kotlinapp.dagger

import com.example.kotlinapp.HomeFragment
import com.example.kotlinapp.OtherFragment
import com.example.kotlinapp.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pear on 6/14/2019.
 */
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun otherFragment(): OtherFragment

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun profileFragment(): ProfileFragment
}