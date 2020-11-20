package com.mfathurz.wartacovid19.data

import com.mfathurz.wartacovid19.data.local.LocalDataSource
import com.mfathurz.wartacovid19.data.remote.RemoteDataSource
import com.mfathurz.wartacovid19.models.GlobalSummaryModel
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import com.mfathurz.wartacovid19.models.ProvinceData
import com.mfathurz.wartacovid19.models.news.Article
import com.mfathurz.wartacovid19.models.news.NewsResponse

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remote: RemoteDataSource, local: LocalDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remote, local)
            }
    }

    suspend fun getIndoSummary(): IndoSummaryModel? = remoteDataSource.getIndoSummary()

    suspend fun getProvinceSummary(): List<ProvinceData>? = remoteDataSource.getProvinceSummary()

    suspend fun getGlobalSummary() : GlobalSummaryModel? = remoteDataSource.getGlobalSummary()

    suspend fun getNews() : List<Article>? = remoteDataSource.getHeadlineNews()

}