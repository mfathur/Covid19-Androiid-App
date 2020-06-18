package com.mfathurz.wartacovid19.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mfathurz.wartacovid19.Constant
import com.mfathurz.wartacovid19.models.Country
import com.mfathurz.wartacovid19.models.Global
import com.mfathurz.wartacovid19.models.ProvinceData
import kotlinx.coroutines.flow.Flow

@Dao
interface CovidDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCountries(countries : List<Country>)

    @Query("SELECT * from country_table")
    fun getAllCountries() : Flow<List<Country>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProvinces(province : List<ProvinceData>)

    @Query("SELECT * from province_table")
    fun getAllProvinces() : Flow<List<ProvinceData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrInsertGlobalData(global : Global)

    @Query("SELECT * from global_table WHERE id=${Constant.ID}")
    fun getGlobalData() : Flow<Global>

}