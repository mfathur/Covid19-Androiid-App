package com.mfathurz.wartacovid19.models

data class GlobalSummaryModel(
    val Countries: List<Country>,
    val Date: String,
    val Global: Global
)