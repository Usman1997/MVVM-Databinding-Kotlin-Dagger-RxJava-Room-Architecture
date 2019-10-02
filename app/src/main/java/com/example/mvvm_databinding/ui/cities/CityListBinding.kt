package com.example.mvvm_databinding.ui.cities

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_databinding.model.CitiesData

object CityListBinding {
    @JvmStatic
    @BindingAdapter("load_cities")
    fun loadCities(recyclerView: RecyclerView, cities: List<CitiesData>?) {
        recyclerView.adapter = if (cities != null) CityListAdapter(cities) else CityListAdapter(emptyList())
    }
}