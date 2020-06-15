package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import retrofit2.Response

class HomeViewModel(private val repo:Repository):ViewModel() {
    val indoCovidSummary:LiveData<Response<IndoSummaryModel>> = liveData {
        emit(repo.getIndoSummary())
    }
}