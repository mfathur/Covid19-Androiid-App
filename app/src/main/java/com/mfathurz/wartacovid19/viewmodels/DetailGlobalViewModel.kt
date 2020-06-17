package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.models.GlobalSummaryModel
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailGlobalViewModel(private val repo :Repository) :ViewModel(){
    val covidGlobalSummary = MutableLiveData<Response<GlobalSummaryModel>>()

    init {
        getGlobalSummary()
    }

    private fun getGlobalSummary() =viewModelScope.launch {
        covidGlobalSummary.postValue(repo.getGlobalSummary())
    }
}