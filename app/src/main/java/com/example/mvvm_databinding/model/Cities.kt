package com.example.mvvm_databinding.model

import com.google.gson.annotations.SerializedName

data class Cities(
        @SerializedName("pagination")
        val pagination: Boolean,
        @SerializedName("data")
        val data: ArrayList<CitiesData>,
        @SerializedName("message")
        val message: String)