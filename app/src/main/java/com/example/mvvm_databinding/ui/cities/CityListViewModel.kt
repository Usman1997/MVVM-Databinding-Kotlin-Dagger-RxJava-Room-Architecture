package com.example.mvvm_databinding.ui.cities

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_databinding.Repository.city.CityRepository
import com.example.mvvm_databinding.model.Cities
import com.example.mvvm_databinding.model.CitiesData
import com.example.mvvm_databinding.ui.base.BaseViewModel
import com.example.mvvm_databinding.utils.Schedulers.BaseScheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class CityListViewModel @Inject constructor(private val cityRepository: CityRepository, private val baseScheduler: BaseScheduler) : BaseViewModel<List<CitiesData>>() {
    val compositeDisposable = CompositeDisposable();
    val repoLifeData = MutableLiveData<ArrayList<CitiesData>>()

    public fun getCities(country_id: String) {
        val repoDisposable = cityRepository.fetchCities(country_id)
                .subscribeOn(baseScheduler.io())
                .observeOn(baseScheduler.ui())
                .subscribeWith(getObserver())
        compositeDisposable.addAll(repoDisposable)
    }

    fun getLiveData(): LiveData<ArrayList<CitiesData>> = repoLifeData
    fun getLoading():LiveData<Boolean> = loadingStatus
    fun getError():LiveData<Throwable> = errorStatus


    fun getObserver(): DisposableObserver<Cities> {
        loadingStatus.value = true
        return object : DisposableObserver<Cities>() {
            override fun onNext(response: Cities) {
                repoLifeData.value = response.data
            }

            override fun onError(e: Throwable) {
                errorStatus.value = e
                loadingStatus.value = false
            }

            override fun onComplete() {
                loadingStatus.value = false
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}