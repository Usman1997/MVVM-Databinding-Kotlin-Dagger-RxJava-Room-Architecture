package com.example.mvvm_databinding.Repository.city

import com.example.mvvm_databinding.model.Cities
import com.example.mvvm_databinding.network.Api
import io.reactivex.Observable
import javax.inject.Inject

class CityRemoteSource @Inject constructor(private val api: Api):CityDataSource {
    override fun fetchCities(country_id: String): Observable<Cities> {
              return api.getCities(country_id)
    }

}