package com.news.app.data.remote.dto

import com.news.app.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)