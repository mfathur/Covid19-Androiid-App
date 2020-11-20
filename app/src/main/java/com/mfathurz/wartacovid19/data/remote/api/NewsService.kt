package com.mfathurz.wartacovid19.data.remote.api

import com.mfathurz.wartacovid19.BuildConfig
import com.mfathurz.wartacovid19.models.news.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?category=health&country=id&apiKey=
interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun getHeadlineNews(
        @Query("category")
        category: String = "health",

        @Query("country")
        country: String = "id",

        @Query("apiKey")
        apiKey: String = BuildConfig.NEWS_API_KEY
    ): Response<NewsResponse>
}
