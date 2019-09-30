package com.example.mvvm_databinding.di.modules

import com.example.mvvm_databinding.ui.main.StarListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    fun contributeMainActivity(): StarListActivity
}