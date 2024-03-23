package com.news.app.presentation.bookmark

import com.news.app.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)