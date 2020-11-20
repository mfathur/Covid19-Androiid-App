package com.mfathurz.wartacovid19.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ProvinceData(
    val fid: Int,
    @SerializedName("kasusMeni")
    val deathCase: Int,
    @SerializedName("kasusPosi")
    val positiveCase: Int,
    @SerializedName("kasusSemb")
    val curedCase: Int,
    @PrimaryKey
    @SerializedName("kodeProvi")
    val provinceCode: Int,
    @SerializedName("provinsi")
    val province: String
)