package com.example.kotlinapp.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pear on 6/12/2019.
 */

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application): Context = application

    // if you need to inject something, start here
}