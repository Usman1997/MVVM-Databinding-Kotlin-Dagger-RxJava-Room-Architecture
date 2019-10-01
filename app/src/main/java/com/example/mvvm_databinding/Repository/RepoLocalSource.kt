package com.example.mvvm_databinding.Repository

import com.example.mvvm_databinding.db.RepoDao
import com.example.mvvm_databinding.model.Repo
import io.reactivex.Observable
import javax.inject.Inject

class RepoLocalSource @Inject constructor(private val repoDao: RepoDao) : RepoDataSource {
    override fun fetchRepos(userName: String): Observable<List<Repo>> {
     return Observable.fromCallable{
           repoDao.fetchAllRepos()
     }
    }

    override fun saveRepos(repos: List<Repo>) {
        repoDao.saveAllMyRepos(repos)
    }
}