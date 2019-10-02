package com.example.mvvm_databinding.ui.cities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_databinding.Repository.city.CityRepository
import com.example.mvvm_databinding.model.CitiesData
import com.example.mvvm_databinding.ui.base.BaseViewModel
import com.example.mvvm_databinding.utils.Schedulers.BaseScheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CityListViewModel @Inject constructor(private val cityRepository: CityRepository, private val baseScheduler: BaseScheduler) : BaseViewModel<List<CitiesData>>()  {
    val compositeDisposable = CompositeDisposable();
    val repoLifeData = MutableLiveData<ArrayList<CitiesData>>()

    public fun getCities(country_id: String) {
        val repoDisposable = cityRepository.fetchCities(country_id)
                .subscribeOn(baseScheduler.io())
                .observeOn(baseScheduler.ui())
                .doOnSubscribe { loadingStatus.setValue(true) }
                .doAfterTerminate { loadingStatus.setValue(false) }
                .subscribe {

                    repoLifeData.value = it.data as ArrayList<CitiesData>?
                }
        compositeDisposable.addAll(repoDisposable)
    }

    fun getLiveData(): LiveData<ArrayList<CitiesData>> = repoLifeData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}