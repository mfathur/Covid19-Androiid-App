package com.mfathurz.wartacovid19

import com.mfathurz.wartacovid19.network.CovidNetwork

class Repository( private val networkService: CovidNetwork) {
        suspend fun getIndoSummary()=networkService.infoCovid.getIndoSummary()
}