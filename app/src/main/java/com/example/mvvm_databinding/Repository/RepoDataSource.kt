package com.example.mvvm_databinding.Repository

import com.example.mvvm_databinding.model.Repo
import io.reactivex.Observable
import java.util.*

interface RepoDataSource {
    fun fetchRepos(userName:String):Observable<List<Repo>>
    fun saveRepos(repos:List<Repo>)
}