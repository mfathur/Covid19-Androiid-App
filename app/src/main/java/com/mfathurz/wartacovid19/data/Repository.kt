package com.mfathurz.wartacovid19.data

import com.mfathurz.wartacovid19.data.local.LocalDataSource
import com.mfathurz.wartacovid19.data.remote.RemoteDataSource

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    companion object{
        @Volatile
        private var instance : Repository? = null

        fun getInstance(remote:RemoteDataSource,local:LocalDataSource): Repository =
            instance ?: synchronized(this){
                instance?: Repository(remote,local)
            }
    }

    suspend fun getIndoSummary() = remoteDataSource.getIndoSummary()

    suspend fun getProvinceSummary() = remoteDataSource.getProvinceSummary()

    suspend fun getGlobalSummary() = remoteDataSource.getGlobalSummary()

    suspend fun getNews() = remoteDataSource.getHeadlineNews()

}