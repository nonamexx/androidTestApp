package com.example.kotlinapp.dagger

import android.app.Activity
import android.app.Application
import com.example.kotlinapp.MainActivity
import com.example.kotlinapp.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by Pear on 6/12/2019.
 */

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidInjectionModule::class,
    ActivityBinder::class,
    ViewModelFactoryModule::class,
    ViewModelModule::class,
    ServiceModule::class
])
interface AppComponent: AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}