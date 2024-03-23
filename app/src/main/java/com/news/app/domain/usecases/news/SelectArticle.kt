package com.news.app.domain.usecases.news

import com.news.app.data.local.NewsDao
import com.news.app.domain.model.Article

class SelectArticle(private val newsDao: NewsDao) {

    suspend operator fun invoke(url: String): Article? {
        return newsDao.getArticle(url)
    }
}