package com.example.mvvm_databinding.ui.cities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_databinding.R
import com.example.mvvm_databinding.databinding.ListCityItemBinding
import com.example.mvvm_databinding.model.CitiesData
import com.example.mvvm_databinding.ui.base.BaseAdapter

class CityListAdapter(list:List<CitiesData>) :BaseAdapter<CitiesData>(list) {
    override fun onCreateViewHolderBase(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_city_item, parent, false)
        return ListCityViewHolder(view)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ListCityViewHolder).binding
        val citiesData = list[position]
        binding?.city = citiesData
    }

    class ListCityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       val binding: ListCityItemBinding? = DataBindingUtil.bind(view)
    }
}