package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.*
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.models.GlobalSummaryModel
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(val repo:Repository):ViewModel() {
    val indoCovidSummary : MutableLiveData<Response<GlobalSummaryModel>> = MutableLiveData()

    init {
        getIndoCovidSummary()
    }

    private fun getIndoCovidSummary() = viewModelScope.launch {
        val response=repo.getGlobalSummary()
        indoCovidSummary.postValue(response)
    }
}