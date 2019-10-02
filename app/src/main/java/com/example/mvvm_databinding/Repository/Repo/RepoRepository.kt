package com.example.mvvm_databinding.Repository.Repo

import com.example.mvvm_databinding.Repository.Repo.RepoDataSource
import com.example.mvvm_databinding.Repository.Repo.RepoLocalSource
import com.example.mvvm_databinding.Repository.Repo.RepoRemoteSource
import com.example.mvvm_databinding.model.Repo
import io.reactivex.Observable
import javax.inject.Inject

class RepoRepository @Inject constructor(private val repoLocalSource: RepoLocalSource, private val repoRemoteSource: RepoRemoteSource): RepoDataSource {
    override fun fetchRepos(userName: String): Observable<List<Repo>> {
        return Observable.concat(repoLocalSource.fetchRepos(userName),repoRemoteSource.fetchRepos(userName = userName)
                .doOnNext { repos->saveRepos(repos) }
                .onErrorResumeNext(Observable.empty()))
    }

    override fun saveRepos(repos: List<Repo>) {
        repoLocalSource.saveRepos(repos)
    }

}