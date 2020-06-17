package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mfathurz.wartacovid19.Repository

class DetailIndonesiaViewModelFactory(private val repo:Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailIndonesiaViewModel(repo) as T
    }

}