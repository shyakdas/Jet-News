package com.news.app.data.remote

import com.news.app.data.remote.dto.NewsResponse
import com.news.app.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ) : NewsResponse
}