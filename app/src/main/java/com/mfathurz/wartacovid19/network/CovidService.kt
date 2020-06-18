package com.mfathurz.wartacovid19.network

import com.mfathurz.wartacovid19.Constant.Companion.COVID_BASE_URL
import com.mfathurz.wartacovid19.models.GlobalSummaryModel
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import com.mfathurz.wartacovid19.models.ProvinceSummaryModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface CovidService {
    @GET("/api")
    suspend fun getIndoSummaryModel():Response<IndoSummaryModel>

    @GET("/api/provinsi")
    suspend fun getProvinceSummaryModel():Response<ProvinceSummaryModel>

    @GET
    suspend fun getGlobalSummary(@Url url :String = "https://api.covid19api.com/summary") : Response<GlobalSummaryModel>
}

object CovidNetwork{
    val retrofit by lazy { Retrofit.Builder()
        .baseUrl(COVID_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    val covidService by lazy { retrofit.create(CovidService::class.java) }
}