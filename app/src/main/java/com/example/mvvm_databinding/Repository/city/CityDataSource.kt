package com.example.mvvm_databinding.Repository.city

import com.example.mvvm_databinding.model.Cities
import io.reactivex.Observable

interface CityDataSource {
    fun fetchCities(country_id:String): Observable<Cities>
}