package com.example.mvvm_databinding.Repository

import com.example.mvvm_databinding.model.Repo
import com.example.mvvm_databinding.network.Api
import io.reactivex.Observable
import javax.inject.Inject

class RepoRepository @Inject constructor(private val api: Api) {
 fun getRepos(userName:String):Observable<List<Repo>>{
     return api.getStarredRepos(userName)
 }
}