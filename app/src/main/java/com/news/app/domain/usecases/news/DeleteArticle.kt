package com.news.app.domain.usecases.news

import com.news.app.domain.model.Article
import com.news.app.domain.repository.NewsRepository

/**
 * Use case class for deleting an article.
 * @param newsRepository The NewsRepository instance for accessing article-related operations.
 */
class DeleteArticle(private val newsRepository: NewsRepository) {

    /**
     * Invokes the use case to delete an article.
     * @param article The article to be deleted.
     */
    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }
}