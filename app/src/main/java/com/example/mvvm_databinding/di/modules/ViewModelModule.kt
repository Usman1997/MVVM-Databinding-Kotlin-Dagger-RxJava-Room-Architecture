package com.example.mvvm_databinding.di.modules


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_databinding.di.keys.ViewModelKey
import com.example.mvvm_databinding.ui.cities.CityListViewModel
import com.example.mvvm_databinding.ui.common.ViewModelFactory
import com.example.mvvm_databinding.ui.main.StarListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Usman Ahmed Siddiqui
 */
@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StarListViewModel::class)
    fun bindStarListViewModel(listStarListViewModel: StarListViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(CityListViewModel::class)
    fun bindCityListViewModel(cityListViewModel: CityListViewModel) : ViewModel

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}