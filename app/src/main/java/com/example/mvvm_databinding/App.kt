package com.example.mvvm_databinding

import android.app.Activity
import android.app.Application
import com.example.mvvm_databinding.di.components.AppComponent
import com.example.mvvm_databinding.di.components.DaggerAppComponent
import com.example.mvvm_databinding.di.modules.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App:Application(),HasAndroidInjector{
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
        appComponent.inject(this)
        AppInjector.init(this)
    }
    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }


}