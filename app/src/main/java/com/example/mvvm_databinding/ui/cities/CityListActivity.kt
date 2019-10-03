package com.example.mvvm_databinding.ui.cities

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_databinding.R
import com.example.mvvm_databinding.databinding.ActivityCityListBinding
import com.example.mvvm_databinding.ui.main.StarListViewModel
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import retrofit2.HttpException
import javax.inject.Inject
import com.example.mvvm_databinding.model.Error.Error
import java.io.IOException


class CityListActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityCityListBinding
    private lateinit var cityListViewModel: CityListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViews();
        cityListViewModel = ViewModelProviders.of(this, viewModelFactory).get(CityListViewModel::class.java)
        getStarredRepos(cityListViewModel)
        observeMyStars(cityListViewModel)
        observeLoading(cityListViewModel)
        observeError(cityListViewModel)
    }

    private fun setUpViews() {
        binding = DataBindingUtil.setContentView(this, com.example.mvvm_databinding.R.layout.activity_city_list)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getStarredRepos(viewModel: CityListViewModel) {
        viewModel.getCities("0")
    }


    private fun observeLoading(viewModel: CityListViewModel) {
        viewModel.getLoading().observe(this, Observer { isLoading ->
            if (isLoading) Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show()
            else Toast.makeText(this, " Not Loading", Toast.LENGTH_LONG).show()
        })
    }

    private fun observeError(viewModel: CityListViewModel){
        viewModel.getError().observe(this, Observer { throwable->
            if (throwable is HttpException) {
                val body = throwable.response().errorBody()
                val gson = Gson()
                val adapter = gson.getAdapter(Error::class.java)
                try {
                    val errorParser = adapter.fromJson(body?.string())
                    Toast.makeText(this,errorParser.errorBody.message,Toast.LENGTH_LONG).show()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        })
    }


    private fun observeMyStars(viewModel: CityListViewModel) {
        viewModel.getLiveData().observe(this, Observer { cities ->
            binding.cities = cities
            binding.executePendingBindings()
        })
    }

}