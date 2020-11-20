package com.mfathurz.wartacovid19.ui.detail_global

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mfathurz.wartacovid19.data.Repository
import com.mfathurz.wartacovid19.models.GlobalSummaryModel
import kotlinx.coroutines.launch

class DetailGlobalViewModel(private val repository : Repository) :ViewModel(){
    private val _covidGlobalSummary = MutableLiveData<GlobalSummaryModel>()

    val covidGlobalSummary : LiveData<GlobalSummaryModel>
        get() = _covidGlobalSummary

    init {
        getGlobalSummary()
    }

    private fun getGlobalSummary() =viewModelScope.launch {
        _covidGlobalSummary.postValue(repository.getGlobalSummary())
    }
}