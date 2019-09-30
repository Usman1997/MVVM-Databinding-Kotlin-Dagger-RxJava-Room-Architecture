package com.example.mvvm_databinding.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repo")
data class Repo (
        @PrimaryKey
        @ColumnInfo(name = "id")
        @SerializedName("id") val id:String,
        @ColumnInfo(name = "name")
        @SerializedName("name") val name:String,
        @ColumnInfo(name = "language")
        @SerializedName("language") val language:String?,
        @ColumnInfo(name ="description")
        @SerializedName("description") val desc: String?,
        @ColumnInfo(name = "stargazers_count")
        @SerializedName("stargazers_count") val starCount: Int)
