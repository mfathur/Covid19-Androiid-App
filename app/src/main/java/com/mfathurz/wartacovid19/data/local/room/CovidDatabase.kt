package com.mfathurz.wartacovid19.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mfathurz.wartacovid19.models.Country
import com.mfathurz.wartacovid19.models.Global
import com.mfathurz.wartacovid19.models.ProvinceData

@Database(entities = [Global::class, Country::class, ProvinceData::class], version = 1)
abstract class CovidDatabase : RoomDatabase() {

    abstract fun getCovidDataDao(): CovidDataDao

    companion object {
        @Volatile
        private var instance: CovidDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CovidDatabase::class.java,
            "db_covid"
        ).build()
    }
}