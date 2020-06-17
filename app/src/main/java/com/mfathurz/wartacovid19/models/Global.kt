package com.mfathurz.wartacovid19.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mfathurz.wartacovid19.Constant


@Entity(tableName = "global_table")
data class Global(
    @PrimaryKey(autoGenerate = false)
    val id : Int = Constant.ID,
    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
)