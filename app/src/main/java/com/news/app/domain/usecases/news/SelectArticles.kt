package com.news.app.domain.usecases.news

import com.news.app.domain.model.Article
import com.news.app.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(private val newsRepository: NewsRepository) {

    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}