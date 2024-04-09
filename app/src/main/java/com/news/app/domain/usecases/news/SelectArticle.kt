package com.news.app.domain.usecases.news

import com.news.app.domain.model.Article
import com.news.app.domain.repository.NewsRepository

/**
 * Use case class for selecting a specific article by URL.
 * @param newsRepository The NewsRepository instance for accessing article-related operations.
 */
class SelectArticle(private val newsRepository: NewsRepository) {

    /**
     * Invokes the use case to select a specific article by URL.
     * @param url The URL of the article to retrieve.
     * @return The article corresponding to the given URL, if it exists; otherwise, null.
     */
    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticle(url)
    }
}