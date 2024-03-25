package com.news.app.domain.usecases.news

import com.news.app.domain.model.Article
import com.news.app.domain.repository.NewsRepository

class UpsertArticle(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }
}