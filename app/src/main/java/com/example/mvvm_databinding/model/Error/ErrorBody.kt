package com.example.mvvm_databinding.model.Error

import com.google.gson.annotations.SerializedName

data class ErrorBody (
        @SerializedName("code") val code:Int,
        @SerializedName("message") val message:String
)