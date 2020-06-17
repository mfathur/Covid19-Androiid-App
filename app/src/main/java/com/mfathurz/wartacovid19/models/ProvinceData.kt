package com.mfathurz.wartacovid19.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "province_table")
data class ProvinceData(
    val fid: Int,
    val kasusMeni: Int,
    val kasusPosi: Int,
    val kasusSemb: Int,
    @PrimaryKey
    val kodeProvi: Int,
    val provinsi: String
)