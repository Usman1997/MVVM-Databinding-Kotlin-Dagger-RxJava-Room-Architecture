package com.example.mvvm_databinding.db

import androidx.room.*
import com.example.mvvm_databinding.model.Repo

@Dao
interface RepoDao {
    @Query("Select * from repo")
    fun fetchAllRepos():List<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMyRepos(repos: List<Repo>)
}