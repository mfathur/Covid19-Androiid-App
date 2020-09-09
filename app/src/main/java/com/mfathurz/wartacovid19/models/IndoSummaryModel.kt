package com.mfathurz.wartacovid19.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class IndoSummaryModel(
    @SerializedName("jumlahKasus")
    val cases: Int,
    @SerializedName("meninggal")
    val death: Int,
    @SerializedName("sembuh")
    val cured: Int
) : Serializable