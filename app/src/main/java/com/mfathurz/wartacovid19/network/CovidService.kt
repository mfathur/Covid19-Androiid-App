package com.mfathurz.wartacovid19.network

import com.mfathurz.wartacovid19.Constant.Companion.COVID_BASE_URL
import com.mfathurz.wartacovid19.models.IndoSummaryModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CovidService {
    @GET("/api")
    suspend fun getIndoSummary():Response<IndoSummaryModel>

}

object CovidNetwork{
    val retrofit=Retrofit.Builder()
        .baseUrl(COVID_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val infoCovid= retrofit.create(CovidService::class.java)
}