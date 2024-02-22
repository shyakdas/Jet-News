package com.news.app.domain.repository

import androidx.paging.PagingData
import com.news.app.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}