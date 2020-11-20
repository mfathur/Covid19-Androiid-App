package com.mfathurz.wartacovid19.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mfathurz.wartacovid19.data.Repository
import com.mfathurz.wartacovid19.models.news.Article
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: Repository) : ViewModel() {
    private val _news = MutableLiveData<List<Article>>()

    val news: LiveData<List<Article>>
        get() = _news

    init {
        getNews()
    }

    private fun getNews() = viewModelScope.launch {
        _news.postValue(repository.getNews())
    }
}