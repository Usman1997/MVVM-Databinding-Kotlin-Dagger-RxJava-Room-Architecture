package com.example.mvvm_databinding.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_databinding.model.Response

abstract class BaseViewModel<T>:ViewModel() {
    val response: MutableLiveData<Response<T>> = MutableLiveData()
    val loadingStatus: MutableLiveData<Boolean> = MutableLiveData()
}