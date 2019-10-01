package com.example.mvvm_databinding.di.modules

import android.app.Application
import android.content.Context
import com.example.mvvm_databinding.App
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Module(includes = [AndroidInjectionModule::class])
object ApplicationContextModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}