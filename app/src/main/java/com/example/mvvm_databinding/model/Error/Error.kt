package com.example.mvvm_databinding.model.Error

import com.google.gson.annotations.SerializedName

data class Error (
        @SerializedName("error") val errorBody:ErrorBody

)