package com.mfathurz.wartacovid19

import com.mfathurz.wartacovid19.network.CovidNetwork
import com.mfathurz.wartacovid19.network.NewsNetwork

class Repository( private val networkService: CovidNetwork) {

        suspend fun getIndoSummary()=networkService.covidService.getIndoSummaryModel()

        suspend fun getProvinceSummary()=networkService.covidService.getProvinceSummaryModel()

        suspend fun getGlobalSummary()=networkService.covidService.getGlobalSummary()

        suspend fun getNews()=NewsNetwork.newsService.getHeadlineNews()

}