package com.example.mvvm_databinding.Repository.city

import com.example.mvvm_databinding.model.Cities
import io.reactivex.Observable
import javax.inject.Inject

class CityRepository @Inject constructor(private val cityRemoteRepository: CityRemoteSource):CityDataSource {
    override fun fetchCities(country_id: String): Observable<Cities> {
       return cityRemoteRepository.fetchCities(country_id)
     }
}