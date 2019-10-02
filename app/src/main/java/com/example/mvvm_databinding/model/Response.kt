package com.example.mvvm_databinding.model

data class Response<out T> (
        val status: Int,
        val data: T?,
        val error: Throwable?
)
