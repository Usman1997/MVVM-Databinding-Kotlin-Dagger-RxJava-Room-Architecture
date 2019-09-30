package com.example.mvvm_databinding.network

import com.example.mvvm_databinding.model.Repo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{user}/starred")
    fun getStarredRepos(@Path("user") username:String): Observable<List<Repo>>
}