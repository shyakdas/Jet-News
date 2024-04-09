package com.news.app.data.remote.dto

import com.news.app.domain.model.Article

/**
 * Data class representing the response from a news API.
 * Contains a list of articles, the status of the response, and the total number of results.
 * @param articles The list of articles retrieved from the news API.
 * @param status The status of the response.
 * @param totalResults The total number of results available.
 */
data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)