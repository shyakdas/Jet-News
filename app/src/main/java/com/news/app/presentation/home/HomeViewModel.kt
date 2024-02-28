package com.news.app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.news.app.domain.usecases.News.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val newsUseCases: NewsUseCases) : ViewModel() {

    val news = newsUseCases.getNews(source = listOf("bbc-news", "abc-news", "al-jazeera-english"))
        .cachedIn(viewModelScope)

}