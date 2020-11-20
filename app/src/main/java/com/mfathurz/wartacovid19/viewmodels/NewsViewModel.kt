package com.mfathurz.wartacovid19.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mfathurz.wartacovid19.Repository
import com.mfathurz.wartacovid19.models.news.NewsResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val repository : Repository) :ViewModel(){
    val news =MutableLiveData<Response<NewsResponse>>()

    init {
        getNews()
    }

    private fun getNews()=viewModelScope.launch {
        news.postValue(repository.getNews())
    }
}