package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.*
import com.mfathurz.wartacovid19.data.Repository
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository):ViewModel() {
    val indoCovidSummary : MutableLiveData<Response<IndoSummaryModel>> = MutableLiveData()

    init {
        getIndoCovidSummary()
    }

    private fun getIndoCovidSummary() = viewModelScope.launch {
        val response=repository.getIndoSummary()
        indoCovidSummary.postValue(response)
    }
}