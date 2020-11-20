package com.mfathurz.wartacovid19.data.remote.api

import com.mfathurz.wartacovid19.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    private val loggingInterceptor by lazy {
        HttpLoggingInterceptor()
    }

    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun getCovidApiService(): CovidService {
        val retrofit =
            Retrofit.Builder()
                .client(client)
                .baseUrl(Constant.COVID_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(CovidService::class.java)
    }

    fun getNewsApiService(): NewsService {
        val retrofit =
            Retrofit.Builder()
                .client(client)
                .baseUrl(Constant.NEWS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(NewsService::class.java)
    }
}