package com.example.mvvm_databinding.di.modules

import android.content.Context
import androidx.room.Room
import com.example.mvvm_databinding.db.AppDatabase
import com.example.mvvm_databinding.db.RepoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object AppDbModule {
    @JvmStatic
    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
                context,
                AppDatabase::class.java, AppDatabase.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRepoDao(appDatabase: AppDatabase): RepoDao {
        return appDatabase.getRepoDao()
    }
}