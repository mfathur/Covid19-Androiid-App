package com.mfathurz.wartacovid19.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mfathurz.wartacovid19.data.Repository
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {
    private val _indoCovidSummary = MutableLiveData<IndoSummaryModel>()

    val indoCovidSummary: LiveData<IndoSummaryModel>
        get() = _indoCovidSummary

    init {
        getIndoCovidSummary()
    }

    private fun getIndoCovidSummary() = viewModelScope.launch {
        _indoCovidSummary.postValue(repository.getIndoSummary())
    }
}