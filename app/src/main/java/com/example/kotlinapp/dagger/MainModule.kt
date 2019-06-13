package com.example.kotlinapp.dagger

import com.example.kotlinapp.HomeFragment
import com.example.kotlinapp.SomeData
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pear on 6/12/2019.
 */
@Module
class MainModule {
    @Provides
    fun provideSomeData(): SomeData = SomeData(
        "123456",
        "Alex",
        123
    )
}