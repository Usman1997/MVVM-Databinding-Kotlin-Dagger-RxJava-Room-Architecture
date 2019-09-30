package com.example.mvvm_databinding.di.components

import com.example.mvvm_databinding.App
import com.example.mvvm_databinding.di.modules.ActivityBuilderModule
import com.example.mvvm_databinding.di.modules.AppModule
import com.example.mvvm_databinding.di.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    ActivityBuilderModule::class])

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}