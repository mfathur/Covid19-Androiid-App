package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.*
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(val repo:Repository):ViewModel() {
    val indoCovidSummary : MutableLiveData<Response<IndoSummaryModel>> = MutableLiveData()

    init {
        getIndoCovidSummary()
    }

    private fun getIndoCovidSummary() = viewModelScope.launch {
        val response=repo.getIndoSummary()
        indoCovidSummary.postValue(response)
    }
}