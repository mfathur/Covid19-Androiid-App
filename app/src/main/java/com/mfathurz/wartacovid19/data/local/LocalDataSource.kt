package com.mfathurz.wartacovid19.data.local

import com.mfathurz.wartacovid19.data.local.room.CovidDataDao
import com.mfathurz.wartacovid19.models.Country
import com.mfathurz.wartacovid19.models.Global
import com.mfathurz.wartacovid19.models.ProvinceData
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val covidDataDao: CovidDataDao) {

    companion object {
        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance(covidDataDao: CovidDataDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(covidDataDao)
            }
    }

    suspend fun insertAllCountries(countries: List<Country>) =
        covidDataDao.insertAllCountries(countries)

    fun getAllCountries(): Flow<List<Country>> = covidDataDao.getAllCountries()

    suspend fun insertAllProvinces(provinces: List<ProvinceData>) =
        covidDataDao.insertAllProvinces(provinces)

    fun getAllProvinces(): Flow<List<ProvinceData>> = covidDataDao.getAllProvinces()

    suspend fun updateOrInsertGlobalData(global: Global) =
        covidDataDao.updateOrInsertGlobalData(global)

    fun getGlobalData(): Flow<Global> = covidDataDao.getGlobalData()
}