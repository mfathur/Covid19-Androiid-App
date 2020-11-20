package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mfathurz.wartacovid19.data.Repository
import com.mfathurz.wartacovid19.models.ProvinceData
import com.mfathurz.wartacovid19.models.ProvinceSummaryModel
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailIndonesiaViewModel(private val repository: Repository) : ViewModel() {
    private val covidProvinceSummary: MutableLiveData<Response<ProvinceSummaryModel>> = MutableLiveData()
    private val provinceData: MutableLiveData<ArrayList<ProvinceData>> = MutableLiveData()

    init {
        getProvinceSummary()
    }

    private fun getProvinceSummary() = viewModelScope.launch {
        covidProvinceSummary.postValue(repository.getProvinceSummary())
    }

    fun getCovidProvinceSummary(): LiveData<Response<ProvinceSummaryModel>> = covidProvinceSummary

}