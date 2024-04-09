package com.news.app.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.news.app.data.local.NewsDao
import com.news.app.data.remote.NewsApi
import com.news.app.data.remote.NewsPagingSource
import com.news.app.data.remote.SearchNewsPagingSource
import com.news.app.domain.model.Article
import com.news.app.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Implementation of the NewsRepository interface for managing news data from remote and local sources.
 * This class provides methods to retrieve news articles, search for articles, and perform CRUD operations on articles.
 * @param newsApi An instance of the NewsApi interface for fetching news from remote sources.
 * @param newsDao An instance of the NewsDao interface for accessing news articles stored locally.
 */
class NewsRepositoryImpl(private val newsApi: NewsApi, private val newsDao: NewsDao) :
    NewsRepository {

    /**
     * Retrieves news articles from remote sources based on provided sources.
     * @param sources The list of sources from which to retrieve news articles.
     * @return A Flow emitting PagingData containing news articles.
     */
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    /**
     * Searches for news articles based on the provided search query and sources.
     * @param searchQuery The search query to be used for searching news articles.
     * @param sources The list of sources to search for news articles.
     * @return A Flow emitting PagingData containing searched news articles.
     */
    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    /**
     * Inserts or replaces an article in the local database.
     * @param article The article to be inserted or replaced.
     */
    override suspend fun upsertArticle(article: Article) {
        newsDao.upsert(article)
    }

    /**
     * Deletes an article from the local database.
     * @param article The article to be deleted.
     */
    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    /**
     * Retrieves all articles stored in the local database.
     * @return A Flow emitting a list of articles stored in the local database.
     */
    override fun selectArticles(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

    /**
     * Retrieves an article from the local database based on its URL.
     * @param url The URL of the article to retrieve.
     * @return The article corresponding to the given URL, if it exists; otherwise, null.
     */
    override suspend fun selectArticle(url: String): Article? {
        return newsDao.getArticle(url)
    }
}