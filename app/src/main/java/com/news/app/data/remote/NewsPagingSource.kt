package com.news.app.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.news.app.domain.model.Article

/**
 * PagingSource implementation for loading news articles from the News API.
 * @param newsApi An instance of the NewsApi interface for fetching news articles.
 * @param sources The comma-separated list of news sources to retrieve articles from.
 */
class NewsPagingSource(private val newsApi: NewsApi, private val sources: String) :
    PagingSource<Int, Article>() {

    private var totalNewsCount = 0

    /**
     * Returns the refresh key for subsequent loads.
     * @param state The current PagingState.
     * @return The refresh key based on the current state.
     */
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    /**
     * Loads a page of news articles.
     * @param params The LoadParams representing the load request.
     * @return A LoadResult containing the loaded articles and pagination keys.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.getNews(sources = sources, page = page)
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title } // Remove the duplicate
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }
}