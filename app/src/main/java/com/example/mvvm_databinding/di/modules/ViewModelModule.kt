package com.example.mvvm_databinding.di.modules


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_databinding.di.keys.ViewModelKey
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
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}