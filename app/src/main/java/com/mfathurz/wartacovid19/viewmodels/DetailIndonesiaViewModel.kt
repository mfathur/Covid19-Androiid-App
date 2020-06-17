package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.models.ProvinceSummaryModel
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailIndonesiaViewModel(private val repo :Repository) :ViewModel(){
   val covidProvinceSummary : MutableLiveData<Response<ProvinceSummaryModel>> = MutableLiveData()

    init {
       getProvinceSummary()
    }

    private fun getProvinceSummary() = viewModelScope.launch{
        covidProvinceSummary.postValue(repo.getProvinceSummary())
    }

}