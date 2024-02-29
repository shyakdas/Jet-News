package com.news.app.domain.usecases.news

import androidx.paging.PagingData
import com.news.app.domain.model.Article
import com.news.app.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(private val newsRepository: NewsRepository) {

    operator fun invoke(source: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = source)
    }
}