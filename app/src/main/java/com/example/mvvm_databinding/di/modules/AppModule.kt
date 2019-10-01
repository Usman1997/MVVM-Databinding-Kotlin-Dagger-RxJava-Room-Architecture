package com.example.mvvm_databinding.di.modules

import android.app.Application
import android.content.Context
import com.example.mvvm_databinding.Repository.RepoLocalSource
import com.example.mvvm_databinding.Repository.RepoRemoteSource
import com.example.mvvm_databinding.Repository.RepoRepository
import com.example.mvvm_databinding.db.RepoDao
import com.example.mvvm_databinding.network.Api
import com.example.mvvm_databinding.utils.Schedulers.BaseScheduler
import com.example.mvvm_databinding.utils.Schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
import com.example.mvvm_databinding.App
import dagger.Binds

@Module(includes = [(ViewModelModule::class)])
class AppModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideScheduler(): BaseScheduler {
        return SchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideRepoRepository(repoLocalSource: RepoLocalSource, repoRemoteSource: RepoRemoteSource): RepoRepository {
        return RepoRepository(repoLocalSource, repoRemoteSource)
    }

    @Provides
    @Singleton
    fun provideRepoLocalSource(repoDao: RepoDao): RepoLocalSource {
        return RepoLocalSource(repoDao)
    }

    @Provides
    @Singleton
    fun provideRepoRemoteSource(api: Api): RepoRemoteSource {
        return RepoRemoteSource(api)
    }




}