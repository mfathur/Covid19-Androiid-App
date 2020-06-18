package com.mfathurz.wartacovid19.network

import com.mfathurz.wartacovid19.Constant
import com.mfathurz.wartacovid19.models.news.NewsResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?category=health&country=id&apiKey=
interface NewsService{

    @GET("/v2/top-headlines")
    suspend fun getHeadlineNews(
        @Query("category")
        category:String = "health",

        @Query("country")
        country:String = "id",

        @Query("apiKey")
        apiKey:String = Constant.NEWS_API_KEY
    ) : Response<NewsResponse>
}

object NewsNetwork{
        private val loggingInterceptor by lazy {
            HttpLoggingInterceptor()
        }

        private val client by lazy {
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        }

        val newsService by lazy {
            Retrofit.Builder()
                .baseUrl(Constant.NEWS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(NewsService::class.java)
        }
}

