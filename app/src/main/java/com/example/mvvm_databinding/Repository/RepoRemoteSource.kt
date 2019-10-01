package com.example.mvvm_databinding.Repository

import com.example.mvvm_databinding.model.Repo
import com.example.mvvm_databinding.network.Api
import io.reactivex.Observable
import javax.inject.Inject

class RepoRemoteSource @Inject constructor(private val api:Api):RepoDataSource {
    override fun fetchRepos(userName: String): Observable<List<Repo>> {
          return api.getStarredRepos(userName)
     }

    override fun saveRepos(repos: List<Repo>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}