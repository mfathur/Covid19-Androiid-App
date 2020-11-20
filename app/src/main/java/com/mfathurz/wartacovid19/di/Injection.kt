package com.mfathurz.wartacovid19.di

import android.content.Context
import com.mfathurz.wartacovid19.data.Repository
import com.mfathurz.wartacovid19.data.local.LocalDataSource
import com.mfathurz.wartacovid19.data.local.room.CovidDatabase
import com.mfathurz.wartacovid19.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): Repository {
        val database = CovidDatabase.getInstance(context)

        val localDataSource = LocalDataSource.getInstance(database.getCovidDataDao())

        val remoteDataSource = RemoteDataSource.getInstance()

        return Repository.getInstance(remoteDataSource, localDataSource)
    }
}