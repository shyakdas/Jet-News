package com.news.app.domain.usecases.news

import androidx.paging.PagingData
import com.news.app.domain.model.Article
import com.news.app.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use case class for retrieving news articles.
 * @param newsRepository The NewsRepository instance for accessing article-related operations.
 */
class GetNews(private val newsRepository: NewsRepository) {

    /**
     * Invokes the use case to retrieve news articles.
     * @param sources The list of sources from which to retrieve news articles.
     * @return A Flow emitting PagingData containing news articles.
     */
    operator fun invoke(source: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = source)
    }
}