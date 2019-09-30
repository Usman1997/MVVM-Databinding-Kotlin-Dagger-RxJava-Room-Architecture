package com.example.mvvm_databinding.di.modules

import com.example.mvvm_databinding.Repository.RepoRepository
import com.example.mvvm_databinding.network.Api
import com.example.mvvm_databinding.utils.Schedulers.BaseScheduler
import com.example.mvvm_databinding.utils.Schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [(ViewModelModule::class)])
class AppModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideScheduler():BaseScheduler{
        return SchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideRepoRepository(api:Api):RepoRepository{
        return RepoRepository(api)
    }
}