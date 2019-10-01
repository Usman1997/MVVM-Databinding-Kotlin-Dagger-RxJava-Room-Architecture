package com.example.mvvm_databinding.di.components

import android.app.Application
import com.example.mvvm_databinding.App
import com.example.mvvm_databinding.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityBuilderModule::class,
    AppDbModule::class,
    ApplicationContextModule::class])

interface AppComponent {
    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}