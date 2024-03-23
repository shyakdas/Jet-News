package com.news.app.domain.usecases.news

import com.news.app.data.local.NewsDao
import com.news.app.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(private val newsDao: NewsDao) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}