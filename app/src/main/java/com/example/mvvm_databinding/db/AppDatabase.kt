package com.example.mvvm_databinding.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_databinding.model.Repo

@Database(entities = arrayOf(Repo::class), version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getRepoDao(): RepoDao
    companion object {
        const val DATABASE_NAME = "repo.db"
    }

}