package com.example.mvvm_databinding

import com.example.mvvm_databinding.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App:DaggerApplication(){
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
         return DaggerAppComponent.builder().create(this)
    }
}