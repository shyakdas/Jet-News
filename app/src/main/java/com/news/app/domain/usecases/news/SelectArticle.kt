package com.news.app.domain.usecases.news

import com.news.app.domain.model.Article
import com.news.app.domain.repository.NewsRepository

class SelectArticle(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticle(url)
    }
}