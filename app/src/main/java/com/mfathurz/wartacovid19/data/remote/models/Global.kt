package com.mfathurz.wartacovid19.models

import com.mfathurz.wartacovid19.Constant

data class Global(
    val id: Int = Constant.ID,
    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
)