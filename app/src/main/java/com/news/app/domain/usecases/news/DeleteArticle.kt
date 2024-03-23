package com.news.app.domain.usecases.news

import com.news.app.data.local.NewsDao
import com.news.app.domain.model.Article

class DeleteArticle(private val newsDao: NewsDao) {

    suspend operator fun invoke(article: Article) {
        newsDao.delete(article)
    }
}