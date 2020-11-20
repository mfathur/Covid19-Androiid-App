package com.mfathurz.wartacovid19.data.remote

import com.mfathurz.wartacovid19.data.remote.api.ApiConfig
import com.mfathurz.wartacovid19.models.GlobalSummaryModel
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import com.mfathurz.wartacovid19.models.ProvinceData
import com.mfathurz.wartacovid19.models.news.Article

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    suspend fun getIndoSummary(): IndoSummaryModel? {
        return try {
            val response = ApiConfig.getCovidApiService().getIndoSummaryModel()
            response.body()
        } catch (e: Exception) {
            return null
        }
    }

    suspend fun getProvinceSummary(): List<ProvinceData>? {
        val list = ArrayList<ProvinceData>()
        return try {
            val response = ApiConfig.getCovidApiService().getProvinceSummaryModel()
            val data = response.body()
            data?.data?.let {
                val iterator = it.iterator()
                while (iterator.hasNext()) {
                    val item = iterator.next()
                    if (item.province != "Indonesia") {
                        list.add(item)
                    }
                }
            }
            list
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun getGlobalSummary(): GlobalSummaryModel? {
        return try {
            val response = ApiConfig.getCovidApiService().getGlobalSummary()
            response.body()
        } catch (e: Exception) {
            return null
        }
    }

    suspend fun getHeadlineNews(): List<Article>? {
        return try {
            val response = ApiConfig.getNewsApiService().getHeadlineNews()
            val data = response.body()
            data?.articles
        } catch (e: Exception) {
            emptyList()
        }
    }

}