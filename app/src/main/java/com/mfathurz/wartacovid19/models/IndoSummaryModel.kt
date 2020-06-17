package com.mfathurz.wartacovid19.models

import java.io.Serializable

data class IndoSummaryModel(
    val jumlahKasus: Int,
    val meninggal: Int,
    val sembuh: Int
) : Serializable