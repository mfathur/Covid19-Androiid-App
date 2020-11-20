package com.mfathurz.wartacovid19.ui.detail_indonesia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mfathurz.wartacovid19.data.Repository
import com.mfathurz.wartacovid19.models.ProvinceData
import kotlinx.coroutines.launch

class DetailIndonesiaViewModel(private val repository: Repository) : ViewModel() {
    private val _covidProvinceSummary = MutableLiveData<List<ProvinceData>>()

    val covidProvinceSummary : LiveData<List<ProvinceData>>
        get() = _covidProvinceSummary

    init {
        getProvinceSummary()
    }

    private fun getProvinceSummary() = viewModelScope.launch {
        _covidProvinceSummary.postValue(repository.getProvinceSummary())
    }
}