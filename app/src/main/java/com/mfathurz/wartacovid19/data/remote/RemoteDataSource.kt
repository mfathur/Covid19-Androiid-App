package com.mfathurz.wartacovid19.data.remote

import com.mfathurz.wartacovid19.data.remote.api.ApiConfig

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    suspend fun getIndoSummary() = ApiConfig.getCovidApiService().getIndoSummaryModel()

    suspend fun getProvinceSummary() = ApiConfig.getCovidApiService().getProvinceSummaryModel()

    suspend fun getGlobalSummary() = ApiConfig.getCovidApiService().getGlobalSummary()

    suspend fun getHeadlineNews() = ApiConfig.getNewsApiService().getHeadlineNews()

}