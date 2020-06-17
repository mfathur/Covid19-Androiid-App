package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mfathurz.wartacovid19.Repository

class HomeViewModelFactory(val repo:Repository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repo) as T
    }
}