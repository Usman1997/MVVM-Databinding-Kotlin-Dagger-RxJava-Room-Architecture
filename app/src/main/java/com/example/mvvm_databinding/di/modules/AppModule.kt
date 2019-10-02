package com.example.mvvm_databinding.di.modules

import com.example.mvvm_databinding.Repository.Repo.RepoLocalSource
import com.example.mvvm_databinding.Repository.Repo.RepoRemoteSource
import com.example.mvvm_databinding.Repository.Repo.RepoRepository
import com.example.mvvm_databinding.Repository.city.CityRemoteSource
import com.example.mvvm_databinding.Repository.city.CityRepository
import com.example.mvvm_databinding.db.RepoDao
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

    @Provides
    @Singleton
    fun provideCityRemoteSource(api:Api): CityRemoteSource {
        return CityRemoteSource(api)
    }

    @Provides
    @Singleton
    fun provideCityRepository(cityRemoteSource: CityRemoteSource):CityRepository{
        return CityRepository(cityRemoteSource)
    }




}