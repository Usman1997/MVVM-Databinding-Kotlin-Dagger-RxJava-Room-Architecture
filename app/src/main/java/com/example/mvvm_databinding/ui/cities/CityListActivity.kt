package com.example.mvvm_databinding.ui.cities

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_databinding.R
import com.example.mvvm_databinding.databinding.ActivityCityListBinding
import com.example.mvvm_databinding.ui.main.StarListViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class CityListActivity:DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityCityListBinding
    private lateinit var cityListViewModel: CityListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViews();
        cityListViewModel = ViewModelProviders.of(this,viewModelFactory).get(CityListViewModel::class.java)
        getStarredRepos(cityListViewModel)
        observeMyStars(cityListViewModel)
        observeResponse(cityListViewModel)
    }

    private fun setUpViews(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_city_list)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeResponse(viewModel: CityListViewModel) {
        viewModel.loadingStatus.observe(
                this,
                androidx.lifecycle.Observer { isLoading ->
                    if (isLoading) {
                        Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Not Loading", Toast.LENGTH_LONG).show()
                    }
                })
    }

    private fun getStarredRepos(viewModel: CityListViewModel) {
        viewModel.getCities("0")
    }

    private fun observeMyStars(viewModel: CityListViewModel) {
        viewModel.getLiveData().observe(this, Observer { cities ->
            binding.cities = cities
            binding.executePendingBindings()
        })
    }

}